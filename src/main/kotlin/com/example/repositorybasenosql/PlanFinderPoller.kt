package com.example.repositorybasenosql

import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToFlux

//Creo el constructor principal en el encabezado con un Parámetro AircraftRepository
@Component //bean
@EnableScheduling
class PlanFinderPoller(private val repository: AircraftRepository) {
    private val client = WebClient.create("http://localhost:7634/aircraft")

    @Scheduled(fixedRate = 1000)
    private fun pollPlanes() {
        repository.deleteAll()
        client.get()
            .retrieve()
            .bodyToFlux<Aircraft>()
            .filter { !it.reg.isNullOrEmpty() }
            .toStream()
            .forEach { repository.save(it) }
        println("--- All aircraft ---")
        repository.findAll().forEach { println(it) }
    }
}
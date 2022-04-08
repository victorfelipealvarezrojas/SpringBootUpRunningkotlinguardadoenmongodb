package com.example.repositorybasenosql

import org.springframework.data.repository.CrudRepository

interface AircraftRepository : CrudRepository<Aircraft,String>
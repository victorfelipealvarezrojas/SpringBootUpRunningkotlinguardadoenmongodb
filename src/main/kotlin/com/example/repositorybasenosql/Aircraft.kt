package com.example.repositorybasenosql

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

/**\
 *   @?        indica que s epuede omitor el campo en el cosntructor y de ser asi
 *             tomara el valor porn defecto asignado con "="
 *
 *   @Document le indica a MongoDB que cada objeto de tipo Aeronave se
 *              almacenará como un documento dentro del base de datos
 *
 *   @data_class    data que precede a la definición de clase. Es un patrón frecuente crear clases
     *              de dominio que sirven principalmente como datos cubos para ser manipulados y/o pasados entre procesos.
     *              es tal patrón común, de hecho, la capacidad de crear las llamadas clases de datos se manifiesta de varias maneras;
     *              como un ejemplo, @Data ha sido una característica de Lombok durante años
 *
 */

@Document
@JsonIgnoreProperties(ignoreUnknown = true)
data class Aircraft (
    @Id
    val id: String,
    val callsign: String? = "",
    val squawk: String? = "",
    val reg: String? = "",
    val flightno: String? = "",
    val route: String? = "",
    val type: String? = "",
    val category: String? = "",
    val altitude: Int? = 0,
    val heading: Int? = 0,
    val speed: Int? = 0,
    @JsonProperty("vert_rate")
    val vertRate: Int? = 0,

    @JsonProperty("selected_altitude")
    val selectedAltitude: Int? = 0,
    val lat: Double? = 0.0,
    val lon: Double? = 0.0,
    val barometer: Double? = 0.0,

    @JsonProperty("polar_distance")
    val polarDistance: Double? = 0.0,

    @JsonProperty("polar_bearing")
    val polarBearing: Double? = 0.0,

    @JsonProperty("is_adsb")
    val isADSB: Boolean? = false,

    @JsonProperty("is_on_ground")
    val isOnGround: Boolean? = false,

    @JsonProperty("last_seen_time")
    val lastSeenTime: Instant? = Instant.ofEpochSecond(0),

    @JsonProperty("pos_update_time")
    val posUpdateTime: Instant? = Instant.ofEpochSecond(0),

    @JsonProperty("bds40_seen_time")
    val bds40SeenTime: Instant? = Instant.ofEpochSecond(0)
)


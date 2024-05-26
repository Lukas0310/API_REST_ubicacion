package org.aguzman.webapp.jaxws.controllers;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.DistanceMatrixElement;
import com.google.maps.model.DistanceMatrixRow;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.aguzman.webapp.jaxws.models.EnvioRequest;
import org.aguzman.webapp.jaxws.models.EnvioResponse;

import java.io.IOException;

@RequestScoped
@Path("/envios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EnvioRestController {

    private static final String API_KEY = "your_google_maps_api_key";
    private static final double COSTO_POR_KILOMETRO = 5.0; // Ejemplo: 5 unidades monetarias por kilómetro

    private GeoApiContext getGeoContext() {
        return new GeoApiContext.Builder().apiKey(API_KEY).build();
    }

    @POST
    @Path("/calcular")
    public Response calcularEnvio(EnvioRequest request) {
        try {
            GeoApiContext context = getGeoContext();
            DistanceMatrix result = DistanceMatrixApi.getDistanceMatrix(context,
                    new String[]{request.getOrigen()},
                    new String[]{request.getDestino()}).await();

            DistanceMatrixRow[] rows = result.rows;
            if (rows.length > 0) {
                DistanceMatrixElement element = rows[0].elements[0];
                double distanciaEnKm = element.distance.inMeters / 1000.0;
                long tiempoEnSegundos = element.duration.inSeconds;
                double tiempoEnMinutos = tiempoEnSegundos / 60.0;
                double costoEnvio = distanciaEnKm * COSTO_POR_KILOMETRO;

                EnvioResponse response = new EnvioResponse(distanciaEnKm, costoEnvio, tiempoEnMinutos);
                return Response.ok(response).build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("No se pudo calcular la distancia. Verifique las direcciones ingresadas.")
                        .build();
            }
        } catch (ApiException | InterruptedException | IOException e) {
            e.printStackTrace();
            return Response.serverError().entity("Error al calcular la distancia: " + e.getMessage()).build();
        }
    }
}

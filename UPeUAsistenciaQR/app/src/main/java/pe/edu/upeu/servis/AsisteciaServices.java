package pe.edu.upeu.servis;

import java.util.List;

import pe.edu.upeu.modelo.AsistenciaTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AsisteciaServices {

    @GET("/EventoUPeU/asist/all")
    Call<List<AsistenciaTO>> listarAsistencia();

    @POST("/EventoUPeU/asist/add/{idEvento}/{idUsuario}/{idPersona}")
    Call<AsistenciaTO> guardarAsistencia(@Body AsistenciaTO asistencia, @Path("idEvento") int idEvento, @Path("idUsuario") int idUsuario, @Path("idPersona") int idPersona);

}

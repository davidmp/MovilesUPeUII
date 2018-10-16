package pe.edu.upeu.servis;

import java.util.List;

import pe.edu.upeu.modelo.AsistenciaTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AsisteciaServices {

    @GET("/EventoUPeU/asist/all")
    Call<List<AsistenciaTO>> listarAsistencia();

    @POST("/EventoUPeU/asist/add")
    Call<AsistenciaTO> guardarAsistencia(@Body AsistenciaTO asistencia);

}

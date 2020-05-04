package com.smartsoft.uat.webservice.service;

import com.smartsoft.uat.business.HorariosBusiness;
import com.smartsoft.uat.business.RecuperarContraseñaBussines;
import com.smartsoft.uat.business.UnidadaprendizajeBusiness;
import com.smartsoft.uat.business.UsuariosBusiness;
import com.smartsoft.uat.controller.CorreoController;
import com.smartsoft.uat.controller.DocenteController;
import com.smartsoft.uat.controller.SesionController;
import com.smartsoft.uat.controller.UsuariosController;
import com.smartsoft.uat.controller.view.CorreoView;
import com.smartsoft.uat.controller.view.SesionView;
import com.smartsoft.uat.controller.view.UsuariosView;
import com.smartsoft.uat.entity.Usuarios;
import java.util.Date;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


@WebService(serviceName = "ServicioWeb")
@Stateless
@LocalBean

public class ServicioWeb {
        @Inject
    private UsuariosBusiness business;
     @Inject
    private HorariosBusiness horariosbusiness;
      @Inject
    private UnidadaprendizajeBusiness unidadAbusiness;
      @Inject
    private RecuperarContraseñaBussines recupBussines;
       @Inject
    private HorariosBusiness horariosBussines;
    
     private Usuarios usuario;
     private UsuariosView usuariosView ;
     private SesionView sesionView;
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Registro")
  public String Registro(@WebParam(name = "nombre") String nombre, 
            @WebParam(name = "apellidoPaterno") String apellidoPaterno, 
            @WebParam(name = "apellidoMaterno") String apellidoMaterno, 
            @WebParam(name = "correo") String correo,
            @WebParam(name = "contrasena") String contrasena,
            @WebParam(name = "confContrasena") String confContrasena,
            @WebParam(name = "tipoUsuario") String tipoUsuario, 
            @WebParam(name = "matricula") String matricula) {
      usuario = new Usuarios();
       usuariosView = new UsuariosView();
       usuario.setNombre(nombre);
         usuario.setApellidoPaterno(apellidoPaterno);
         usuario.setApellidoMaterno(apellidoMaterno);
        usuario.setCorreo(correo);
         usuario.setContrasena(contrasena);
         usuario.setRol(tipoUsuario);
         usuario.setMatricula(matricula);
         
        usuariosView.setEntity(usuario);
         usuariosView.setListaEntity(null);
        usuariosView.getEntity().setId(0);
        usuariosView.getEntity().setActivo(true);
        usuariosView.getEntity().setFechaRegistro(new Date());
        
        UsuariosController controller = new UsuariosController();  
    // return controller.nuevoWS(nuevoUsuario.getNombre(),nuevoUsuario.getApellidoPaterno());
    String retorno=null;
     retorno = controller.guardarWS(usuariosView , business);
    System.out.println(retorno);
    
      return retorno;
      
   
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "inicioSesion")
   public String InicioSesion(@WebParam(name = "correo") String correo, @WebParam(name = "contrasena") String contrasena) {
        usuario= new Usuarios();
        sesionView = new SesionView(); 
        sesionView.setUsuario(usuario);
        sesionView.getUsuario().setCorreo(correo);
        sesionView.getUsuario().setContrasena(contrasena);
        SesionController controller = new SesionController(); 
        String retorno=controller.iniciarSesionWS(sesionView, business);
        System.out.println(retorno);
        return retorno;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "recuperarContrasena")
    public String recuperarContrasena(@WebParam(name = "correo") String correo) {
        CorreoView view = new CorreoView();
       
         CorreoController controller = new CorreoController();
        view.setDestinatario(correo);
          
      return controller.enviarCorreoWS(view,recupBussines);
        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getMariasDocente")
    public String getMariasDocente(@WebParam(name = "matricula") String matricula) {
        DocenteController controller = new DocenteController();  
        
         System.out.println("Holaaaaaaaaa");
        System.out.println(controller.obtenerListaUnidades(unidadAbusiness, matricula));
        
      return  controller.obtenerListaUnidades(unidadAbusiness, matricula);
      
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAulasUnidadAprendizaje")
    public String getAulasUnidadAprendizaje(@WebParam(name = "unidadAprendizaje") String unidadAprendizaje) {
      DocenteController controller = new DocenteController();
       System.out.println(controller.obtenerAultaUnidadAprendizaje(unidadAprendizaje, horariosbusiness));
        return   controller.obtenerAultaUnidadAprendizaje(unidadAprendizaje, horariosbusiness);
    }

    
    
    
    
    
}
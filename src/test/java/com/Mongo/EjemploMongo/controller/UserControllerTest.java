package com.Mongo.EjemploMongo.controller;

import com.Mongo.EjemploMongo.dto.UserDto;
import com.Mongo.EjemploMongo.model.User;
import com.Mongo.EjemploMongo.service.user.UserService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//Esta línea de código indica que la clase de prueba utiliza el orden definido por las anotaciones de orden. Esto significa
// que los métodos de prueba se ejecutarán en el orden definido por la anotación @Order que se coloque en los métodos de prueba.
@ExtendWith(MockitoExtension.class)
//Esta línea de código indica que la clase de prueba utiliza la extensión de Mockito para gestionar las instancias simuladas
// (mocks) y simplificar las operaciones de mocking en las pruebas. Mockito es una biblioteca que permite crear mocks y verificar interacciones con ellos durante las pruebas.
class UserControllerTest {


    @Mock
    private UserService userService;
    //Aquí se está creando un mock (simulación) de la clase UserService. Un mock es una versión simulada de un objeto real, que se utiliza para aislar la funcionalidad de la
    // clase actual y centrarse en probar específicamente la funcionalidad de la clase que se está probando. Los métodos de userService se pueden configurar para devolver valores
    // predefinidos o comportamientos específicos durante las pruebas.

    @InjectMocks
    private UserController userController;
    //La anotación @InjectMocks se utiliza para inyectar automáticamente los mocks creados con la anotación @Mock en la instancia de UserController. Esto permite que los métodos
    // de userController utilicen los mocks configurados previamente en lugar de los objetos reales.

    @Test
    @Order(1)
    public void get_all_status200 (){
    //Esta línea de código declara un método de prueba llamado get_all_status200 y le asigna el orden 1 para la ejecución según la anotación @Order. Este método de prueba verifica
     // el comportamiento de algún aspecto del método getAll en la clase UserController.

        List<User> userListMock = new ArrayList<>();
        userListMock.add(new User("user1", "user1@gmail.com", "123s"));
        userListMock.add(new User("user2", "user2@gmail.com", "154s"));
        userListMock.add(new User("user3", "user3@gmail.com", "187s"));

        //En estas líneas de código, se crea una lista de objetos User simulados. Cada objeto User tiene un nombre de usuario, una dirección de correo electrónico y una contraseña
        // simulada. Esta lista se utiliza para configurar el comportamiento esperado del mock de UserService
        Mockito.when(userService.findAll()).thenReturn(userListMock);

        //Aquí se configura el mock de UserService para que, cuando se llame al método findAll(), en lugar de ejecutar la implementación real de ese método, devuelva la lista de
        // usuarios simulados userListMock. Esto simula el comportamiento del servicio y permite que el controlador utilice la lista simulada en lugar de acceder a la base de datos real.
        ResponseEntity<List<User>> listUserController = userController.getAll();
        //Se llama al método getAll() del controlador userController, que debería estar configurado para utilizar el mock de UserService con la lista simulada. Esto se hace para obtener
        // la respuesta del controlador cuando se solicita obtener todos los usuarios.
        Assertions.assertEquals(200, listUserController.getStatusCodeValue());

        //Finalmente, se verifica que la respuesta del controlador tenga un código de estado HTTP 200 (OK). Esto asegura que, según el comportamiento simulado del mock de UserService,
        // la solicitud para obtener todos los usuarios se maneje correctamente y devuelva una respuesta exitosa.
    }


    @Test
    @Order(3)
    public void find_by_id_200(){

        User userMockito = new User( "user1","user@gmail.com","sebas123");
        Mockito.when(userService.findById(Mockito.anyString())).thenReturn(userMockito);
        //Se configura el mock de UserService para que, cuando se llame al método findById con cualquier cadena (usando Mockito.anyString()), devuelva el objeto userMockito. Esto simula
        // el comportamiento del servicio para que cuando se busque un usuario por su ID, siempre devuelva el objeto simulado.

        ResponseEntity<User> userResult = userController.findById("sdrw");
        //Se llama al método findById("sdrw") del controlador userController, que debería estar configurado para utilizar el mock de UserService con el objeto simulado. Esto se hace para
        // obtener la respuesta del controlador cuando se solicita encontrar un usuario por su ID.
        Assertions.assertEquals(200,userResult.getStatusCodeValue());
        //Finalmente, se verifica que la respuesta del controlador tenga un código de estado HTTP 200 (OK). Esto asegura que, según el comportamiento simulado del mock de UserService,
        // la solicitud para obtener todos los usuarios se maneje correctamente y devuelva una respuesta exitosa.
    }

    @Test
    @Order(4)
    public void update_user(){

        UserDto userMockito = new UserDto( "user1","user@gmail.com","sebas123");
        User userMockitoUpdate = new User(userMockito);
        //Se crea un objeto User simulado (userMockitoUpdate) a partir del objeto userMockito. Esto se hace para simular cómo podría lucir el usuario actualizado en la base de datos después
        // de que se haya realizado la actualización.

        Mockito.when(userService.update("1",userMockito)).thenReturn(userMockitoUpdate);
        //Se configura el mock de UserService para que, cuando se llame al método update con el ID "1" y el objeto userMockito, devuelva el objeto userMockitoUpdate. Esto simula el comportamiento
        // del servicio para que cuando se actualice un usuario con el ID "1", siempre devuelva el objeto simulado de usuario actualizado.


        ResponseEntity<User> userResponseEntity  =  userController.updateUser("1", userMockito);
        //Se llama al método updateUser("1", userMockito) del controlador userController, que debería estar configurado para utilizar el mock de UserService con el objeto simulado. Esto se hace
        // para obtener la respuesta del controlador cuando se solicita actualizar un usuario.


        Assertions.assertEquals(200,userResponseEntity.getStatusCodeValue());
        //Se verifica que la respuesta del controlador tenga un código de estado HTTP 200 (OK). Esto asegura que, según el comportamiento simulado del mock de UserService, la solicitud para
        // actualizar un usuario se maneje correctamente y devuelva una respuesta exitosa.

        Assertions.assertTrue(userResponseEntity.getBody() != null);
        //Se verifica que el cuerpo de la respuesta (getBody()) no sea nulo. Esto comprueba que la respuesta del controlador contiene información sobre el usuario actualizado.

    }

}
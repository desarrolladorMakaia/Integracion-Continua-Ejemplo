package com.Mongo.EjemploMongo.service.user;

import com.Mongo.EjemploMongo.dto.UserDto;
import com.Mongo.EjemploMongo.model.User;
import com.Mongo.EjemploMongo.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
//Cuando usas @ExtendWith(MockitoExtension.class), estás permitiendo que Mockito se encargue de crear y administrar los
// mocks que se utilizan en tu clase de prueba. Esta extensión se encarga de inicializar los mocks antes de cada prueba,
// para que estén listos para su uso, y también se encarga de verificar las interacciones con los mocks después de que se ejecuta cada prueba.
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        userService = new UserServiceImpl(userRepository);
    }
    //@BeforeEach: Es una anotación de JUnit 5 que indica que el método anotado debe ejecutarse antes de cada método de prueba
    // en la misma clase.public void setUp() { ... }: Este es el método que se ejecutará antes de cada prueba. El nombre del
    // método (setUp en este caso) puede ser personalizado según las preferencias, pero es comúnmente usado para métodos de
    // inicialización.userService = new UserServiceImpl(userRepository);: En este caso, se está creando una instancia de
    // UserServiceImpl, que es una clase que implementa la interfaz UserService. Esto se hace para tener una instancia
    // de UserService disponible y lista para ser utilizada en las pruebas.

    @Test
    public void find_all_users() {
        List<User> userListMock = new ArrayList<>();
        userListMock.add(new User("user1", "user1@gmail.com", "123s"));
        userListMock.add(new User("user2", "user2@gmail.com", "154s"));
        userListMock.add(new User("user3", "user3@gmail.com", "187s"));

        Mockito.when(userRepository.findAll()).thenReturn(userListMock);
        //Se configura el mock de userRepository para que, cuando se llame al método findAll, devuelva la lista de usuarios
        // simulados userListMock. Esto simula el comportamiento del repositorio para que cuando se solicite obtener todos
        // los usuarios, devuelva la lista simulada.


        List<User> userListResult = userService.findAll();
        //Se llama al método findAll() de userService, que debería estar configurado para utilizar el mock de userRepository
        // con la lista simulada. Esto se hace para obtener la lista de usuarios resultante.

        List<User> userListExpected = new ArrayList<>();
        userListExpected.add(new User("user1", "user1@gmail.com", "123s"));
        userListExpected.add(new User("user2", "user2@gmail.com", "154s"));
        userListExpected.add(new User("user3", "user3@gmail.com", "187s"));

        //Se crea otra lista de objetos User (userListExpected) que contiene los mismos datos que los usuarios simulados.
        // Esta lista representa la lista de usuarios esperada después de llamar al método findAll().


        Assertions.assertEquals(userListExpected, userListResult);

        //Finalmente, se verifica que la lista de usuarios resultante (userListResult) sea igual a la lista de usuarios esperada
        // (userListExpected). Esto asegura que el método findAll() del servicio funcione correctamente y devuelve la lista de usuarios simulada.

    }

    @Test
    public void find_user_by_id(){
        User userMock = new User("user","user@gmail.com","ada123");
        Mockito.when(userRepository.findById("ada123")).thenReturn(userMock);
        //Se configura el mock de userRepository para que, cuando se llame al método findById("ada123"),
        // devuelva el objeto userMock. Esto simula el comportamiento del repositorio para que cuando se busque un usuario por
        // su ID "ada123", devuelva el objeto simulado de usuario.

        User userResult = userService.findById("ada123");
        //Se llama al método findById("ada123") de userService, que debería estar configurado para utilizar el mock de userRepository con
        // el objeto simulado. Esto se hace para obtener el usuario resultante.

        User userExpected = new User("user","user@gmail.com","ada123");
        //Se crea otro objeto User (userExpected) que contiene los mismos datos que el usuario simulado. Este objeto representa el usuario
        // esperado después de llamar al método findById().

        Assertions.assertEquals(userExpected, userResult);
        //Finalmente, se verifica que el usuario resultante (userResult) sea igual al usuario esperado (userExpected). Esto asegura que el
        // método findById() del servicio funcione correctamente y devuelva el usuario simulado esperado.
    }
    @Test
        public void create_user(){
            UserDto userInput = new UserDto("user1","user1@gmail.com","sebas123");
            User userMock = new User(userInput);
            //Aquí se crea un objeto UserDto simulado (userInput) con un nombre de usuario, una dirección de correo electrónico y una contraseña
            // simulada. Luego, se crea un objeto User simulado (userMock) utilizando el constructor que toma un objeto UserDto. Esto crea un
            // objeto User basado en los datos del objeto userInput.

            Mockito.when(userRepository.create(Mockito.any(UserDto.class)))
                    .thenReturn(userMock);
            //Se configura el mock de userRepository para que, cuando se llame al método create con cualquier instancia de UserDto, devuelva el
        // objeto userMock. Esto simula el comportamiento del repositorio para que cuando se cree un usuario a partir de un UserDto, devuelva el
        // objeto simulado de usuario.


            UserDto userInput2 = new UserDto("user2","user2@gmail.com","sebas123");
            //Se crea otro objeto UserDto (userInput2) con diferentes datos de usuario simulados.


            User userResult = userService.create(userInput2);
            //Se llama al método create(userInput2) de userService, que debería estar configurado para utilizar el mock de userRepository con
            // el objeto userInput2. Esto se hace para obtener el usuario resultante después de la creación.



        //Assertions.assertTrue(userResult.getEmail().equals("user1@gmail.com"));



            User userExpected = new User("user1","user1@gmail.com","sebas123");

            ////Se crea un objeto User (userExpected) basado en los datos del objeto userInput. Esto representa el usuario esperado después de
        // llamar al método create().

            Assertions.assertTrue(userResult.getEmail().equals("user1@gmail.com"));
            // //Finalmente, se verifica que el correo electrónico del usuario resultante (userResult) sea igual al correo electrónico esperado
        // (user1@gmail.com). Esto asegura que el método create() del servicio funcione correctamente y devuelva el usuario simulado
        // esperado con el correo electrónico correcto.



    }




}
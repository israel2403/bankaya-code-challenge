package com.bankaya.code.challenge.pokeapi_soap_service.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

@ExtendWith(SpringExtension.class)
@TestPropertySource(locations = "classpath:application.yml")
/* @Import(PokeApiServiceUnitTest.TestConfig.class) */
public class PokeApiServiceUnitTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private PokeApiService pokeApiService;

    @Value("${pokeapi.base-url}")
    private String baseUrl;

    /* @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        setField(pokeApiService, "baseUrl", baseUrl);

        // Ensure the mock behavior is defined here
        String pokemonName = "pikachu";
        PokemonDTO mockPokemonDTO = PokemonDTO.builder()
                .id(25L)
                .name("pikachu")
                .baseExperience(112)
                .build();
        
        when(restTemplate.getForObject(baseUrl + "/" + pokemonName, PokemonDTO.class))
                .thenReturn(mockPokemonDTO);
    } */

   /*  @Test
    public void testGetPokemonByName_Success() {
        String pokemonName = "pikachu";

        PokemonDTO pokemonDTO = pokeApiService.getPokemonByName(pokemonName);

        assertNotNull(pokemonDTO, "PokemonDTO should not be null");
        assertEquals(pokemonName, pokemonDTO.getName().toLowerCase(), "Pokemon name should match");
        assertEquals(25L, pokemonDTO.getId(), "Pokemon ID should match");
        assertEquals(112, pokemonDTO.getBaseExperience(), "Base experience should match");

        verify(restTemplate, times(1)).getForObject(baseUrl + "/" + pokemonName, PokemonDTO.class);
    }

    @Test
    public void testGetPokemonByName_Exception() {
        String pokemonName = "invalidname";

        when(restTemplate.getForObject(baseUrl + "/" + pokemonName, PokemonDTO.class))
                .thenThrow(new RuntimeException("Not Found"));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            pokeApiService.getPokemonByName(pokemonName);
        });

        assertEquals("java.lang.RuntimeException: Not Found", exception.getMessage(), "Exception message should match");

        verify(restTemplate, times(1)).getForObject(baseUrl + "/" + pokemonName, PokemonDTO.class);
    }

    private void setField(Object targetObject, String fieldName, Object fieldValue) throws Exception {
        Field field = targetObject.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(targetObject, fieldValue);
    }

    @TestConfiguration
    static class TestConfig {
        @Bean
        public RestTemplate restTemplate() {
            return mock(RestTemplate.class);
        }
    } */
}

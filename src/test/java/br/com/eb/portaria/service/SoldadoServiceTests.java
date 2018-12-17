package br.com.eb.portaria.service;

import br.com.eb.portaria.model.Soldado;
import br.com.eb.portaria.repository.SoldadoRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SoldadoServiceTests {
    @Mock
    private SoldadoRepository sdRepo;

    @InjectMocks
    private SoldadoService sdService;

    private static List<Soldado> sds;

    @Before
    public void setUp() {
        // criando "O banco de dados"
        sds = new ArrayList<>();
        sds.add(new Soldado((long) 1001,
                1001,
                "Ítalo",
                "Exarch",
                "SI",
                "Wart",
                "1234"));

        sds.add(new Soldado((long) 1002,
                1002,
                "Igor",
                "Iguh",
                "ES",
                "logon",
                "1234"));

        sds.add(new Soldado((long) 1003,
                1003,
                "Max",
                "dog",
                "SI",
                "Dog",
                "1234"));
    }

    @Test
    public void cadastrarSoldado() {
        Soldado sd = sds.get(0);
        when(sdRepo.save(sd)).thenReturn(sd);
        sdService.adicionarSoldado(sd);
        assertThat(sdRepo.save(sd)).isEqualTo(sd);
        verify(sdRepo, atMost(2)).save(sd);
    }
    @Test
    public void buscarSoldado() {
        Soldado sd = sds.get(0);
        when(sdRepo.findByNumero(sd.getNumero())).thenReturn(sd);
        assertThat(sdService.buscarPorNumero(sd.getNumero())).isEqualTo(sd);
        verify(sdRepo, atMost(1)).findByNumero(sd.getNumero());
    }
    @Test
    public void listarTodosOsSoldados() {
        when(sdRepo.findAll()).thenReturn(sds);
        assertThat(sdService.todosOsSoldados()).isEqualTo(sds);
        verify(sdRepo, atMost(1)).findAll();
    }
    @Test
    public void existePorId() {
        when(sdRepo.existsById((long) 1001)).thenReturn(true);
        assertThat(sdService.existePorId((long) 1001)).isEqualTo(true);
        verify(sdRepo, atMost(1)).existsById((long) 1001);
    }
    @Test
    public void existePorNumero() {
        when(sdRepo.existsByNumero(1001)).thenReturn(true);
        assertThat(sdService.existePorNumero(1001)).isEqualTo(true);
        verify(sdRepo, atMost(1)).existsByNumero(1001);
    }
    @Test
    public void buscarPorId() {
        when(sdRepo.getOne((long) 1001)).thenReturn(sds.get(0));
        assertThat(sdService.buscarPorId((long) 1001)).isEqualTo(sds.get(0));
        verify(sdRepo, atMost(1)).findByNumero(1001);
    }
    @Test
    public void buscarPorNumero() {
        when(sdRepo.findByNumero(1001)).thenReturn(sds.get(0));
        assertThat(sdService.buscarPorNumero(1001)).isEqualTo(sds.get(0));
        verify(sdRepo, atMost(1)).findByNumero(1001);
    }
    @Test
    public void listaSoldadosVazia() {
        sds.clear();
        when(sdRepo.findAll()).thenReturn(sds);
        assertThat(sdService.todosOsSoldados()).isEqualTo(sds);
        verify(sdRepo, atMost(1)).findAll();
    }
}

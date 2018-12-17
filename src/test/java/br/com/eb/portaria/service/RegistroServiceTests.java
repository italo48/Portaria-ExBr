package br.com.eb.portaria.service;

import br.com.eb.portaria.model.Registro;
import br.com.eb.portaria.model.Soldado;
import br.com.eb.portaria.repository.RegistroRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class RegistroServiceTests {
    @Mock
    private RegistroRepository regRepo;
    @InjectMocks
    private RegistroService registroService;
    @Mock
    private Soldado sd;
    @Mock
    private Date dataRegistro;

    private List<Registro> tabelaRegistros;

    @Before
    public void setUp() {
        Registro reg1;
        Registro reg2;
        Registro reg3;

        tabelaRegistros = new ArrayList<>();

        reg1 = new Registro(dataRegistro, sd, "Entrada");
        reg1.setId((long) 01);

        reg2 = new Registro(dataRegistro, sd, "Saida");
        reg2.setId((long) 02);

        reg3 = new Registro(dataRegistro, sd, "Entrada");
        reg3.setId((long) 03);

        tabelaRegistros.add(reg1);
        tabelaRegistros.add(reg2);
        tabelaRegistros.add(reg3);

    }
    @Test
    public void listarRegistros() {
        when(regRepo.findAll()).thenReturn(tabelaRegistros);
        assertThat(registroService.listarRegistros()).isEqualTo(tabelaRegistros);
        verify(regRepo, atMost(1)).findAll();
    }
    @Test
    public void listaDeRegistrosVazia() {
        tabelaRegistros.clear();
        when(regRepo.findAll()).thenReturn(tabelaRegistros);
        assertThat(registroService.listarRegistros()).isEqualTo(tabelaRegistros);
        verify(regRepo, atMost(1)).findAll();
    }
    @Test
    public void registrar() {
        when(regRepo.save(tabelaRegistros.get(0))).thenReturn(tabelaRegistros.get(0));
        registroService.adicionarRegistro(tabelaRegistros.get(0));
        assertThat(regRepo.save(tabelaRegistros.get(0))).isEqualTo(tabelaRegistros.get(0));
        verify(regRepo, atMost(2)).save(tabelaRegistros.get(0));
    }
}

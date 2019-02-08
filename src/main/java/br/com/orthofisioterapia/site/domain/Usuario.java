package br.com.orthofisioterapia.site.domain;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
/**
 * Created by Abmael on 05/02/2019.
 */

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    @NotBlank(message = "Favor informar um nome") @Size(min = 3, max = 50, message = "O nome deve se entre 5  e 50")
    private String nome;

    @Column(nullable = false, length = 50)
    @NotBlank(message = "Favor informar um sobre nome") @Size(min = 3, max = 50, message = "O sobrenome deve se entre 5  e 50")
    private String sobrenome;

    @Column(name = "data_nascimento", columnDefinition = "DATE")
    @NotNull(message = "Informe a data de nascimento.")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dtNascimento;

    @Column(name = "tipo_sexo")
    @Enumerated(EnumType.STRING)
    private TipoSexo sexo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(LocalDate dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public TipoSexo getSexo() {
        return sexo;
    }

    public void setSexo(TipoSexo sexo) {
        this.sexo = sexo;
    }

}

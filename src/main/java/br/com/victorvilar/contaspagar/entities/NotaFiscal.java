package br.com.victorvilar.contaspagar.entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "notas_fiscais")
public class NotaFiscal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;
    private LocalDate dataEmissao;

    @OneToOne
    @JoinColumn(name="despesa_id")
    private DespesaAvulsa despesa;

    public DespesaAvulsa getDespesa() {
        return despesa;
    }

    public void setDespesa(DespesaAvulsa despesa) {
        this.despesa = despesa;
    }

    public NotaFiscal() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (id == null) {
            return false;
        }

        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NotaFiscal other = (NotaFiscal) obj;
        return Objects.equals(this.id, other.id);
    }

}

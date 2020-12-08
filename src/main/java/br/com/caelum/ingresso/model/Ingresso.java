package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.persistence.*;

import br.com.caelum.ingresso.model.descontos.Desconto;


@Entity
public class Ingresso {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer Id;
	
	@ManyToOne
	private Sessao sessao;
	
	@ManyToOne
    private Lugar lugar;
	
	private BigDecimal preco;
	
	@Enumerated(EnumType.STRING)
	
	private TipoDeIngresso tipoDeIngresso;
	
	
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Lugar getLugar() {
		return lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

	public TipoDeIngresso getTipoDeIngresso() {
		return tipoDeIngresso;
	}

	public void setTipoDeIngresso(TipoDeIngresso tipoDeIngresso) {
		this.tipoDeIngresso = tipoDeIngresso;
	}

	public Ingresso(){
	}
	
	public Ingresso(Sessao sessao, TipoDeIngresso tipoDeIngresso, Lugar lugar) {
		 this.sessao = sessao;
		 this.tipoDeIngresso = tipoDeIngresso;
		 this.preco = this.tipoDeIngresso.aplicaDesconto(sessao.getPreco());
		 
		 this.lugar= lugar;
    }
	
	public BigDecimal getPreco() {
		 return preco.setScale(2, RoundingMode.HALF_UP);
    }
	
	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

	public void setPreco(BigDecimal preco) {
		 this.preco = preco;
   }
	

}

package br.com.victorvilar.contaspagar.veiculos.entities;

import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;


/** 
 * Classe para reprensetar uma moto
 * */
@Entity
@DiscriminatorValue("moto")
public class Moto extends VeiculoAbstrato{


}

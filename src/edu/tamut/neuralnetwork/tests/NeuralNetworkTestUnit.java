package edu.tamut.neuralnetwork.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.tamut.neuralnetwork.NeuralNetwork;

public class NeuralNetworkTestUnit {
	
	@Test
	public void RandomConstructor(){
		//TODO
		fail("Not implemented.");
	}
	
	@Test
	public void InitializedConstructor(){
		//TODO
		fail("Not implemented.");
	}
	
	@Test
	public void Prediction(){
		try {
			NeuralNetwork network = new NeuralNetwork(1, 1);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}

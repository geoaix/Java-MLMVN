package edu.tamut.neuralnetwork.tests;
import static org.junit.Assert.*;
import edu.tamut.neuralnetwork.Neuron;

import org.junit.Test;

import edu.tamut.util.Complex;


public class NeuronTestUnit {

	@Test
	public void RandomConstructor(){
		Neuron neuron = new Neuron(10);
		assertEquals(11, neuron.numberOfWeights());
	}
	
	@Test
	public void InitializedConstructor(){
		Complex[] weights = {new Complex(3.0,  2.0), new Complex(4.0,  3.0)};
		Neuron neuron = new Neuron(weights);
		assertArrayEquals(weights, neuron.getWeights());
	}
	
	//TODO: Test failed constructors
	
	@Test
	public void Prediction(){
		Complex[] weights = {new Complex(3.0,  2.0), new Complex(4.0,  3.0)};
		Complex[] inputs = {new Complex(2.0, 1.0)};
		Neuron neuron = new edu.tamut.neuralnetwork.Neuron(weights);
		try {
			Complex prediction = neuron.predict(inputs);
			assertEquals(new Complex(8.0, 12.0), prediction);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void Backprop(){
		Complex[] weights = {new Complex(3.0,  2.0), new Complex(4.0,  3.0)};
		Neuron neuron = new edu.tamut.neuralnetwork.Neuron(weights);
		
	}
	
	//TODO: Test failed prediction
}

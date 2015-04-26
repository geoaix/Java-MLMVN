package edu.tamut.neuralnetwork.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.tamut.neuralnetwork.Neuron;
import edu.tamut.neuralnetwork.NeuronLayer;
import edu.tamut.util.Complex;

public class NeuronLayerTestUnit {

	@Test
	public void RandomConstructor(){
		try {
			NeuronLayer layer = new NeuronLayer(5, 5);
			assertEquals(5, layer.size());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void InitializedConstructor(){
		try{
			Neuron[] neurons = {	new Neuron(5),
									new Neuron(5),
									new Neuron(5),
									new Neuron(5),
									new Neuron(5)};
			NeuronLayer layer = new NeuronLayer(neurons);
			assertArrayEquals(neurons, layer.getNeurons());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void Prediction(){
		try {
			Complex[] firstNeuronWeights = {new Complex(3.0,  2.0), new Complex(4.0,  3.0)};
			Complex[] secondNeuronWeights = {new Complex(3.0,  2.0), new Complex(4.0,  3.0)};
			Complex[] inputs = {new Complex(2.0, 1.0)};
			
			Neuron[] neurons = {new Neuron(firstNeuronWeights), new Neuron(secondNeuronWeights)};
			NeuronLayer layer = new NeuronLayer(neurons);
			Complex[] predictions = layer.predict(inputs);
			
			assertArrayEquals(new Complex[] {new Complex(8, 12),  new Complex(8, 12)}, predictions);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	//TODO: Test failed constructors
	
}
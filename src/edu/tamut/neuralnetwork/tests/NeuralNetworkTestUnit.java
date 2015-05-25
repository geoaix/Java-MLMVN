package edu.tamut.neuralnetwork.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.tamut.neuralnetwork.NeuralNetwork;
import edu.tamut.neuralnetwork.Neuron;
import edu.tamut.neuralnetwork.NeuronLayer;
import edu.tamut.util.Complex;

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
			Complex[] inputLayerWeights = {new Complex(3.0,  2.0), new Complex(4.0,  3.0)};
			Complex[] outputLayerWeights = {new Complex(3.0,  2.0), new Complex(4.0,  3.0)};
			Complex[] inputs = {new Complex(2.0, 1.0)};
			
			NeuralNetwork network = new NeuralNetwork(1, 1);
			NeuronLayer inputLayer = new NeuronLayer(new Neuron[] {new Neuron(inputLayerWeights)});
			network.setInputLayer(inputLayer);
			
			NeuronLayer hiddenLayer = new NeuronLayer(new Neuron[] {new Neuron(outputLayerWeights)});
			network.addHiddenLayer(hiddenLayer);
			
			Complex[] predictions = network.predict(inputs);
			assertArrayEquals(new Complex[] {new Complex(-1.0, 74)}, predictions);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void Backprop(){
		try{
			Complex[] inputLayerWeights = {new Complex(3.0,  2.0), new Complex(4.0,  3.0)};
			Complex[] outputLayerWeights = {new Complex(3.0,  2.0), new Complex(4.0,  3.0)};
			Complex[] inputs = {new Complex(2.0, 1.0)};
			
			NeuralNetwork network = new NeuralNetwork(1, 1);
			NeuronLayer inputLayer = new NeuronLayer(new Neuron[] {new Neuron(inputLayerWeights)});
			network.setInputLayer(inputLayer);
			
			NeuronLayer hiddenLayer = new NeuronLayer(new Neuron[] {new Neuron(outputLayerWeights)});
			network.addHiddenLayer(hiddenLayer);
			
			//network.backprop(null);
		}catch (Exception e) {
			fail(e.getMessage());
		}
	}
}

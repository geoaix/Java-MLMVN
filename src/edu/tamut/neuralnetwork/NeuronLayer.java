package edu.tamut.neuralnetwork;

import java.util.ArrayList;

import edu.tamut.util.Complex;


public class NeuronLayer {
	
	private Neuron[] neurons;
	
	public NeuronLayer(int numberOfNeurons, int numberOfInputs) throws Exception{
		if(numberOfNeurons < 1){
			throw new Exception("The number of neurons should be greater than one.");//TODO: Custom exception?
		}
		if(numberOfInputs < 1){
			throw new Exception("The number of inputs should be greater than one.");//TODO: Custom exception?
		}
		neurons = new Neuron[numberOfNeurons];
		for(int i = 0; i < numberOfNeurons; ++i){
			neurons[i] = new Neuron(numberOfInputs);
		}
	}
	
	public Complex[] predict(Complex[] inputs) throws Exception{
		Complex[] predictions = new Complex[this.neurons.length];
		for(int i = 0; i < this.neurons.length; ++i){
			try {
				predictions[i] = neurons[i].predict(inputs);
			} catch (Exception e) {
				throw new Exception(e);
			}
		}
		return predictions;
	}
}

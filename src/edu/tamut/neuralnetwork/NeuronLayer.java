package edu.tamut.neuralnetwork;

import java.util.Arrays;

import edu.tamut.util.Complex;


public class NeuronLayer {//TODO: Unit tests
	
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
	
	public NeuronLayer(Neuron[] neurons) throws Exception{
		if(neurons.length < 1){
			throw new Exception("The number of neurons should be greater than one.");//TODO: Custom exception?
		}
		this.neurons = neurons;
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
	
	/**
	 * For layer "j", this method takes in the error from "j+1", 
	 * corrects the weights based on this error,
	 * then calculates and returns the errors for layer "j-1" 
	 * @param errors from the proceeding layer (or the errors of the network in the case of the output layer)
	 * @return
	 */
	public Complex[] backprop(Complex[] errors)
	{
		Complex[] nextErrors = new Complex[size()];
		Complex complexSize = new Complex(size(), 0.0);
		Complex[] tmpErrors;
		
		for(int neur = 0; neur < size(); ++neur)
		{
			for(int err=0; err < errors.length; ++err)
			{
				//Step 1: Correct weights
				tmpErrors = neurons[neur].backprop(errors[err], complexSize);
				for(int i = 0; i < nextErrors.length; ++i)
				{
					nextErrors[i] = nextErrors[i].plus(tmpErrors[i]);
				}
			}
		}
		
		//Step 3: Return the errors for the previous layer
		return nextErrors;
	}
	
	public int size(){
		return neurons.length;
	}
	
	public Neuron[] getNeurons(){
		return Arrays.copyOf(this.neurons, this.neurons.length);
	}
}

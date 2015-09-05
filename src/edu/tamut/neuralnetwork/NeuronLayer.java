package edu.tamut.neuralnetwork;

import java.util.Arrays;

import edu.tamut.util.Complex;

import javax.naming.OperationNotSupportedException;


public class NeuronLayer {//TODO: Unit tests
	
	private Neuron[] neurons;
	private NeuronLayer previousLayer = null;
	private NeuronLayer nextLayer = null;
	
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
			neurons[i].setParent(this);
		}
	}
	
	public NeuronLayer(Neuron[] neurons) throws Exception{
		if(neurons.length < 1){
			throw new Exception("The number of neurons should be greater than one.");//TODO: Custom exception?
		}
		this.neurons = neurons;
		for(Neuron neuron : neurons) {
			neuron.setParent(this);
		}
	}

	public void setPreviousLayer(NeuronLayer previousLayer) throws OperationNotSupportedException {
		if(this.previousLayer == null) {
			this.previousLayer = previousLayer;
		} else {
			throw new OperationNotSupportedException("Cannot change a layer's previous layer.");
		}
	}

	public NeuronLayer getPreviousLayer() {
		return this.previousLayer;
	}

	public void setNextLayer(NeuronLayer nextLayer) throws OperationNotSupportedException {
		if(this.nextLayer == null) {
			this.nextLayer = nextLayer;
		} else {
			throw new OperationNotSupportedException("Cannot change a layer's next layer.");
		}
	}

	public NeuronLayer getNextLayer() {
		return this.nextLayer;
	}

	public boolean isInputLayer() {
		return (previousLayer == null);
	}

	public boolean isHiddenLayer() {
		return (previousLayer != null && nextLayer != null);
	}

	public boolean isOutputLayer() {
		return (nextLayer == null);
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

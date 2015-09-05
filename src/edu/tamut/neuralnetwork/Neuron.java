package edu.tamut.neuralnetwork;

import java.util.Arrays;
import java.util.Random;

import edu.tamut.util.Complex;

import javax.naming.OperationNotSupportedException;

public class Neuron implements Cloneable{//TODO: Implement serializable
	
	private Complex[] weights;
	private static final Random RAND = new Random();

	private NeuronLayer parent = null;
	
	/**
	 * @param numberOfInputs The number of inputs that will be passed to this Neuron. The number of weights is numberOfInputs + 1 since there is a bias weight.
	 */
	public Neuron(int numberOfInputs){
		this.weights = new Complex[numberOfInputs + 1];
		this.randomizeWeights();
	}
	
	public Neuron(Complex[] weights){
		this.weights = weights;
	}

	public void setParent(NeuronLayer parent) throws OperationNotSupportedException {
		if(this.parent == null) {
			this.parent = parent;
		}else {
			throw new OperationNotSupportedException("You cannot change the parent of a Neuron.");
		}
	}
	
	public Complex predict(Complex[] inputs) throws Exception{
		if(inputs.length != weights.length-1){
			throw new Exception(String.format("Incorrect number of inputs. Expected %d and got %d.", weights.length-1, inputs.length));//TODO: Figure out what exception this should be.
		}
		
		Complex tmp;
		Complex total = weights[0];//Bias weight is always multiplied by 1.0 + 0.0i = bias weight
		
		for(int i = 1; i < weights.length; ++i){
			tmp = weights[i].times(inputs[i-1]);
			total = total.plus(tmp);
		}
		
		return total;
	}
	
	public Complex[] backprop(Complex error, Complex layerSize)
	{
		//Step 1: Calculate errors for the previous layer
		Complex[] nextError = getErrorBackprop(error, layerSize);
		//Step 2: Correct weights
		//Step 3: Return the errors for the previous layer
		return nextError;
	}
	
	//Calculates the error that should be backpropagated
	private Complex[] getErrorBackprop(Complex error, Complex layerSize)
	{
		Complex[] nextError = new Complex[this.weights.length-1];
		for(int i = 1; i < weights.length; ++i)
		{
			nextError[i] = error.divides(weights[i]).divides(layerSize);			
		}
		return nextError; 
	}
	
	public void randomizeWeights(){
		for(int i = 0; i < weights.length; ++i){
			weights[i] = new Complex(RAND.nextDouble(), RAND.nextDouble());
		}
	}
	
	public int numberOfWeights(){
		return this.weights.length;
	}
	
	public Complex[] getWeights(){
		return Arrays.copyOf(this.weights, this.weights.length);
	}
}

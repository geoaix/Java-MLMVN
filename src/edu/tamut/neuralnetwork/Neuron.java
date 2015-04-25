package edu.tamut.neuralnetwork;

import java.io.Serializable;
import java.util.Random;

import edu.tamut.util.Complex;

public class Neuron{//TODO: Implement serializable
	
	private Complex[] weights;
	private static final Random RAND = new Random();
	
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
	
	public Complex predict(Complex[] inputs) throws Exception{
		if(inputs.length != weights.length){
			throw new Exception(String.format("Incorrect number of inputs. Expected %d and got %d. The bias input (1.0 + 0.0i) might be missing.", weights.length, inputs.length));//TODO: Figure out what exception this should be.
		}
		
		Complex total = new Complex(0.0, 0.0);
		Complex tmp;
		
		for(int i = 0; i < weights.length; ++i){
			tmp = weights[i].times(inputs[i]);
			total = total.plus(tmp);
		}
		
		return total;
	}
	
	public void randomizeWeights(){
		for(int i = 0; i < weights.length; ++i){
			weights[i] = new Complex(RAND.nextDouble(), RAND.nextDouble());
		}
	}
}

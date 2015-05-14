package edu.tamut.neuralnetwork;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import edu.tamut.util.Complex;

public class NeuralNetwork {
	
	private NeuronLayer inputLayer;
	private LinkedList<NeuronLayer> hiddenLayers;
	
	public NeuralNetwork(int numberOfNeurons, int numberOfInputs) throws Exception{//TODO: Unit tests
		try {
			setInputLayer(numberOfNeurons, numberOfInputs);
		} catch (Exception e) {
			throw new Exception(e);
		}
		hiddenLayers = new LinkedList<NeuronLayer>();
	}
	
	public void setInputLayer(int numberOfNeurons, int numberOfInputs) throws Exception{
		try {
			inputLayer = new NeuronLayer(numberOfNeurons, numberOfInputs);
			hiddenLayers = new LinkedList<NeuronLayer>();
		} catch (Exception e) {
			throw new Exception(e);//TODO: Custom exception?
		}
	}
	
	/**
	 * Adds an input layer that has already been initialized.
	 * WARNING: This should be used carefully, as it does not check whether the neurons in
	 * the layer have the correct number of weights. The responsibility is yours if you use
	 * this method.
	 * @param layer
	 */
	public void setInputLayer(NeuronLayer layer){
		this.inputLayer = layer;
	}
	
	public void addHiddenLayer(int numberOfNeurons) throws Exception{
		try {
			if(hiddenLayers.size() < 1){
					hiddenLayers.add(new NeuronLayer(numberOfNeurons, inputLayer.size()));
			}else{
				NeuronLayer previous = hiddenLayers.getLast();
				hiddenLayers.add(new NeuronLayer(numberOfNeurons, previous.size()));
			}
		} catch (Exception e) {
			throw new Exception(e);//TODO: Custom exception?
		}
	}
	
	/**
	 * Adds a hidden layer that has already been initialized.
	 * WARNING: This should be used carefully, as it does not check whether the neurons in
	 * the layer have the correct number of weights. The responsibility is yours if you use
	 * this method.
	 * @param layer
	 */
	public void addHiddenLayer(NeuronLayer layer){
		this.hiddenLayers.add(layer);
	}
	
	/**
	 * Removes the last hidden layer added to the network.
	 */
	public void removeHiddenLayer(){
		this.hiddenLayers.removeLast();
	}
	
	/**
	 * Removes all the hidden layers added to the network.
	 */
	public void resetHiddenLayers(){
		this.hiddenLayers = new LinkedList<NeuronLayer>();
	}
	
	public Complex[] predict(Complex[] inputs) throws Exception{
		try {
			Complex[] output = inputLayer.predict(inputs);
			for(NeuronLayer layer : hiddenLayers){
				output = layer.predict(output);
			}
			return output;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	public void backprop(Complex[] errors){
		//TODO: Implement
		ListIterator<NeuronLayer> hiddenLayerIterator = hiddenLayers.listIterator(hiddenLayers.size());
	}
}

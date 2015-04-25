package edu.tamut.neuralnetwork;

import java.util.LinkedList;

public class NeuralNetwork {
	
	private NeuronLayer inputLayer;
	private LinkedList<NeuronLayer> hiddenLayers;
	
	public NeuralNetwork(){//TODO: Unit tests
		hiddenLayers = new LinkedList<NeuronLayer>();
	}
	
	public void addInputLayer(int numberOfNeurons, int numberOfInputs) throws Exception{
		try {
			inputLayer = new NeuronLayer(numberOfNeurons, numberOfInputs);
		} catch (Exception e) {
			throw new Exception(e);//TODO: Custom exception?
		}
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
}

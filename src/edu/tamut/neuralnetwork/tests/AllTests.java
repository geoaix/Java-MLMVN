package edu.tamut.neuralnetwork.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({	NeuronTestUnit.class,
				NeuronLayerTestUnit.class,
				NeuralNetworkTestUnit.class})
public class AllTests {

}

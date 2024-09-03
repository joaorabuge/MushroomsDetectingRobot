package simulator;
import net.sourceforge.jFuzzyLogic.FIS;

import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import weka.classifiers.trees.J48;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class Main {

	public static void main(String[] args) throws Exception {



		String filename = "cogumelo.fcl";

		FIS fis = FIS.load(filename, true);

		Simulator simulator = new Simulator();

		if (fis == null) {

			System.err.println("o ficheiro: '" + filename + "' não consegue carregar");

			System.exit(1);

		}

		DataSource origem = new DataSource("mushroom.arff");

		Instances t = origem.getDataSet();
		J48 clasfi = new J48();

		t.setClassIndex(t.numAttributes()-1);



		FunctionBlock function = fis.getFunctionBlock(null);



		clasfi.buildClassifier(t); 


		while(true) {

			NewInstances i = new NewInstances(t);

			if(simulator.getMushroomAttributes() != null) {

				i.addInstance(simulator.getMushroomAttributes());

				Instances instances = i.getDataset();
				Instance cogumelo = instances.instance(0);

				double num = clasfi.classifyInstance(cogumelo);

				function.setVariable("cogumelo", num);


				function.setVariable("cogumelo", num);

			} else {

				function.setVariable("cogumelo", 0.5);
			}

			function.setVariable("esquerda", simulator.getDistanceL());


			function.setVariable("meio", simulator.getDistanceC());


			function.setVariable("direita",simulator.getDistanceR());


			function.evaluate();

			if(function.getVariable("acao").defuzzify() == 15) {

				simulator.setAction(Action.DESTROY);

			} else if(function.getVariable("acao").defuzzify() == 25) {


				simulator.setAction(Action.PICK_UP);


			} else if(function.getVariable("acao").defuzzify() == 5) {


				simulator.setAction(Action.NO_ACTION);
			}

			double ang = function.getVariable("angulo").defuzzify();

			simulator.setRobotAngle(ang);


			simulator.step();
		}
	}
}
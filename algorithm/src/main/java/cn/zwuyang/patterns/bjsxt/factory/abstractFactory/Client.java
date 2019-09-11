package cn.zwuyang.patterns.bjsxt.factory.abstractFactory;

public class Client {

	public static void main(String[] args) {
		CarFactory  factory = new LuxuryCarFactory();
		Engine e = new LuxuryCarFactory().createEngine();
		e.run();
		e.start();
		
		
	}
}

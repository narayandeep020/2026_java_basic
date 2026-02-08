package org.enumeration;

public class EnumAsVariable {
	enum TrafficLight {
		RED, GREEN, YELLOW;
	}

	public static void main(String[] args) {
		TrafficLight signal = TrafficLight.YELLOW;

		if (signal == TrafficLight.RED) {
			System.out.println("Stop!");
		} else if (signal == TrafficLight.GREEN) {
			System.out.println("Go!");
		} else
			System.out.println("Get Ready....");
	}

}

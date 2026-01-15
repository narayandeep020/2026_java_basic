package com.oopconcepts;

interface WaterDomain {
	default void waterinfo() {
		System.out.println("This is Water Species.");
	}
}

interface LandDomain {
	default void landinfo() {
		System.out.println("This is Land Species.");
	}
}

class SemiDomain implements WaterDomain, LandDomain {
	SemiDomain() {
		System.out.println("This is Amphibian Species.");
	}
}

public class InheritanceMultiple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SemiDomain sd = new SemiDomain();
		sd.waterinfo();
		sd.landinfo();
	}

}

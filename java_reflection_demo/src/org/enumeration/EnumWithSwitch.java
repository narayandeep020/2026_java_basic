package org.enumeration;

public class EnumWithSwitch {
	enum Direction {
		NORTH, SOUTH, EAST, WEST;
	}

	public static void main(String[] args) {
		Direction d = Direction.EAST;

		switch (d) {
		case NORTH:
			System.out.println("North");
			break;

		case SOUTH:
			System.out.println("South");
			break;

		case EAST:
			System.out.println("East");
			break;
		default:
			System.out.println("Other day");
		}
	}

}

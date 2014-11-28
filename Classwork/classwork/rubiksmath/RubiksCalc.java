package rubiksmath;

import java.math.BigInteger;

public class RubiksCalc {
	
	public static String gottaCalcEmAll() {
		String toReturn;
		BigInteger closest = BigInteger.valueOf(10).pow(100);
		int closestBlankCorners = 0;
		int closestBlankEdges = 0;
		int closestCornerSet1 = 0;
		int closestCornerSet2 = 0;
		int closestCornerSet3 = 0;
		int closestCornerSet4 = 0;
		int closestEdgeSet1 = 0;
		int closestEdgeSet2 = 0;
		int closestEdgeSet3 = 0;
		int closestEdgeSet4 = 0;
		int closestEdgeSet5 = 0;
		int closestEdgeSet6 = 0;
		for(int i = 0; i <=8; i++) { //number of corners on a cube
			for(int blankCorners = 0; blankCorners <= i; blankCorners++) {
				for(int cornerSet1 = 0; (cornerSet1 <= 4) && (cornerSet1 + blankCorners <= i); cornerSet1++) {
					for(int cornerSet2 = 0; (cornerSet2 <= cornerSet1) && (cornerSet1 + cornerSet2 + blankCorners <= i); cornerSet2++) {	
						for(int cornerSet3 = 0; (cornerSet3 <= cornerSet2) && (cornerSet1 + cornerSet2 + cornerSet3 + blankCorners <= i); cornerSet3++) {	
							for(int cornerSet4 = 0; (cornerSet4 <= cornerSet3) && (cornerSet1 + cornerSet2 + cornerSet3 + + cornerSet4 + blankCorners <= i); cornerSet4++) {	
								for(int j = 0; j <=12; j++) { //number of edges on a cube
									for(int blankEdges = 0; blankEdges <= j; blankEdges++) {
										for(int edgeSet1 = 0; (edgeSet1 <= 4) && (edgeSet1 + blankEdges <= j); edgeSet1++) {
											for(int edgeSet2 = 0; (edgeSet2 <= edgeSet1) && (edgeSet1 + edgeSet2 + blankEdges <= j); edgeSet2++) {	
												for(int edgeSet3 = 0; (edgeSet3 <= edgeSet2) && (edgeSet1 + edgeSet2 + edgeSet3 + blankEdges <= j); edgeSet3++) {	
													for(int edgeSet4 = 0; (edgeSet4 <= edgeSet3) && (edgeSet1 + edgeSet2 + edgeSet3 + + edgeSet4 + blankEdges <= j); edgeSet4++) {	
														for(int edgeSet5 = 0; (edgeSet5 <= edgeSet4) && (edgeSet1 + edgeSet2 + edgeSet3 + + edgeSet4 + + edgeSet5 + blankEdges <= j); edgeSet5++) {	
															for(int edgeSet6 = 0; (edgeSet6 <= edgeSet5) && (edgeSet1 + edgeSet2 + edgeSet3 + + edgeSet4 + + edgeSet5 + + edgeSet6 + blankEdges <= j); edgeSet6++) {
																BigInteger val = RubiksCalc.calc3By3Combos(blankCorners, blankEdges, cornerSet1, cornerSet2, cornerSet3, cornerSet4, edgeSet1, edgeSet2, edgeSet3, edgeSet4, edgeSet5, edgeSet6);
																double doubleVal = val.doubleValue();
																BigInteger difference = val.subtract(BigInteger.valueOf(1000000)).abs();
																if(difference.min(closest).equals(difference)) {
																	closest = difference;
																	closestBlankCorners = blankCorners;
																	closestBlankEdges = blankEdges;
																	closestCornerSet1 = cornerSet1;
																	closestCornerSet2 = cornerSet2;
																	closestCornerSet3 = cornerSet3;
																	closestCornerSet4 = cornerSet4;
																	closestEdgeSet1 = edgeSet1;
																	closestEdgeSet2 = edgeSet2;
																	closestEdgeSet3 = edgeSet3;
																	closestEdgeSet4 = edgeSet4;
																	closestEdgeSet5 = edgeSet5;
																	closestEdgeSet6 = edgeSet6;
																}
															}
														}										
													}										
												}					
											}
										}
									}
								}			
							}										
						}					
					}
				}
			}
		}
		toReturn = "There were " + closestBlankCorners + " blank corners,\n"
					+ closestBlankEdges + " blank edges,\n"
					+ closestCornerSet1 + " corners in set 1,\n"
					+ closestCornerSet2 + " corners in set 2,\n"
					+ closestCornerSet3 + " corners in set 3,\n"
					+ closestCornerSet4 + " corners in set 4,\n"
					+ closestEdgeSet1 + " edges in set 1,\n"
					+ closestEdgeSet2 + " edges in set 2,\n"
					+ closestEdgeSet3 + " edges in set 3,\n"
					+ closestEdgeSet4 + " edges in set 4,\n"
					+ closestEdgeSet5 + " edges in set 5,\n"
					+ closestEdgeSet6 + " edges in set 6,\n"
					+ "and "+ closest + " combinations total.";
		return toReturn;
	}
	
	public static int durationTest() {
		int toReturn = 0;
		for(int i = 0; i < Integer.MAX_VALUE; i++) {
			for(int j = 0; j < Integer.MAX_VALUE; j++) {
				for(int k = 0; k < Integer.MAX_VALUE; k++) {
					for(int l = 0; l < Integer.MAX_VALUE; l++) {
						for(int m = 0; m < Integer.MAX_VALUE; m++) {
							for(int n = 0; n < Integer.MAX_VALUE; n++) {
								toReturn += toReturn + 1;
							}
						}
					}
				}
			}
		}
		return toReturn;
	}

	public static BigInteger calc3By3Combos(int blankCorners, int blankEdges, int cornerSet1, int cornerSet2, 
							   int cornerSet3, int cornerSet4, int edgeSet1, int edgeSet2, 
							   int edgeSet3, int edgeSet4, int edgeSet5, int edgeSet6) {
		if(blankCorners==0) {
			blankCorners = 1;
		}
		if(blankEdges==0) {
			blankEdges = 1;
		}
		BigInteger returnable = BigInteger.valueOf((long)Math.pow(3, 7)).multiply(BigInteger.valueOf((long)Math.pow(2, 10))
				).multiply(RubiksCalc.factorial(BigInteger.valueOf(12))).multiply(RubiksCalc.factorial(BigInteger.valueOf(8)));
		long returbaleLong = returnable.longValue();
		returnable = returnable.divide(BigInteger.valueOf((long) Math.pow(3, blankCorners - 1))
				).divide(BigInteger.valueOf((long) Math.pow(2, blankEdges - 1))
				).divide(RubiksCalc.factorial(BigInteger.valueOf((long) blankEdges))
				).divide(RubiksCalc.factorial(BigInteger.valueOf((long) blankCorners))
				).divide(RubiksCalc.factorial(BigInteger.valueOf((long) cornerSet1))
						).divide(RubiksCalc.factorial(BigInteger.valueOf((long) cornerSet2))
								).divide(RubiksCalc.factorial(BigInteger.valueOf((long) cornerSet3))
										).divide(RubiksCalc.factorial(BigInteger.valueOf((long) cornerSet4))
				).divide(RubiksCalc.factorial(BigInteger.valueOf((long) edgeSet1))
						).divide(RubiksCalc.factorial(BigInteger.valueOf((long) edgeSet2))
								).divide(RubiksCalc.factorial(BigInteger.valueOf((long) edgeSet3))
										).divide(RubiksCalc.factorial(BigInteger.valueOf((long) edgeSet4))
												).divide(RubiksCalc.factorial(BigInteger.valueOf((long) edgeSet5))
														).divide(RubiksCalc.factorial(BigInteger.valueOf((long) edgeSet6)));
		return returnable;
	}

	public static BigInteger factorial(BigInteger val) {
		BigInteger toReturn = BigInteger.valueOf(1);
		for(int i = 1; i <= val.intValue(); i++) {
			toReturn = toReturn.multiply(BigInteger.valueOf((long) i));
		}
		return toReturn;
	}
}

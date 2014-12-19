package rubiksmath;

import java.math.BigInteger;

public class RubiksCalc2 {
	
	public static String gottaCalcEmAll(long target) {
		String toReturn;
		BigInteger closestDif = BigInteger.valueOf(10).pow(100);
		BigInteger closestVal = BigInteger.valueOf(10).pow(100);
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
		for(int modifiedCorners = 0; modifiedCorners <=8; modifiedCorners++) { //number of corners on a cube
			for(int blankCorners = 0; blankCorners <= modifiedCorners; blankCorners++) {
				for(int cornerSet1 = 0; (cornerSet1 <= 4) && (cornerSet1 + blankCorners <= modifiedCorners); cornerSet1++) {
					for(int cornerSet2 = 0; (cornerSet2 <= cornerSet1) && (cornerSet1 + cornerSet2 + blankCorners <= modifiedCorners); cornerSet2++) {	
						for(int cornerSet3 = 0; (cornerSet3 <= cornerSet2) && (cornerSet1 + cornerSet2 + cornerSet3 + blankCorners <= modifiedCorners); cornerSet3++) {	
							for(int cornerSet4 = 0; (cornerSet4 <= cornerSet3) && (cornerSet1 + cornerSet2 + cornerSet3 + + cornerSet4 + blankCorners <= modifiedCorners); cornerSet4++) {	
								for(int modifiedEdges = 0; modifiedEdges <=12; modifiedEdges++) { //number of edges on a cube
									for(int blankEdges = 0; blankEdges <= modifiedEdges; blankEdges++) {
										for(int edgeSet1 = 0; (edgeSet1 <= 4) && (edgeSet1 + blankEdges <= modifiedEdges); edgeSet1++) {
											for(int edgeSet2 = 0; (edgeSet2 <= edgeSet1) && (edgeSet1 + edgeSet2 + blankEdges <= modifiedEdges); edgeSet2++) {	
												for(int edgeSet3 = 0; (edgeSet3 <= edgeSet2) && (edgeSet1 + edgeSet2 + edgeSet3 + blankEdges <= modifiedEdges); edgeSet3++) {	
													for(int edgeSet4 = 0; (edgeSet4 <= edgeSet3) && (edgeSet1 + edgeSet2 + edgeSet3 + + edgeSet4 + blankEdges <= modifiedEdges); edgeSet4++) {	
														for(int edgeSet5 = 0; (edgeSet5 <= edgeSet4) && (edgeSet1 + edgeSet2 + edgeSet3 + + edgeSet4 + + edgeSet5 + blankEdges <= modifiedEdges); edgeSet5++) {	
															for(int edgeSet6 = 0; (edgeSet6 <= edgeSet5) && (edgeSet1 + edgeSet2 + edgeSet3 + + edgeSet4 + + edgeSet5 + + edgeSet6 + blankEdges <= modifiedEdges); edgeSet6++) {
																BigInteger val = RubiksCalc.calc3By3Combos(blankCorners, blankEdges, cornerSet1, cornerSet2, cornerSet3, cornerSet4, edgeSet1, edgeSet2, edgeSet3, edgeSet4, edgeSet5, edgeSet6);
																BigInteger difference = val.subtract(BigInteger.valueOf(target)).abs();
																if(difference.min(closestDif).equals(difference)) {
																	closestVal = val;
																	closestDif = difference;
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
					+ closestCornerSet1 + " corners in set 1,\n"
					+ closestCornerSet2 + " corners in set 2,\n"
					+ closestCornerSet3 + " corners in set 3,\n"
					+ closestCornerSet4 + " corners in set 4,\n"
					+ closestBlankEdges + " blank edges,\n"
					+ closestEdgeSet1 + " edges in set 1,\n"
					+ closestEdgeSet2 + " edges in set 2,\n"
					+ closestEdgeSet3 + " edges in set 3,\n"
					+ closestEdgeSet4 + " edges in set 4,\n"
					+ closestEdgeSet5 + " edges in set 5,\n"
					+ closestEdgeSet6 + " edges in set 6,\n"
					+ closestDif + " combinations away,\n"
					+ "and "+ closestVal + " combinations total.";
		return toReturn;
	}
	
//	public static int durationTest() {
//		int toReturn = 0;
//		for(int i = 0; i < Integer.MAX_VALUE; i++) {
//			for(int j = 0; j < Integer.MAX_VALUE; j++) {
//				for(int k = 0; k < Integer.MAX_VALUE; k++) {
//					for(int l = 0; l < Integer.MAX_VALUE; l++) {
//						for(int m = 0; m < Integer.MAX_VALUE; m++) {
//							for(int n = 0; n < Integer.MAX_VALUE; n++) {
//								toReturn += toReturn + 1;
//							}
//						}
//					}
//				}
//			}
//		}
//		return toReturn;
//	}

	public static BigInteger calc3By3Combos(int blankCorners, int blankEdges, int cornerSet1, int cornerSet2, 
							   int cornerSet3, int cornerSet4, int edgeSet1, int edgeSet2, 
							   int edgeSet3, int edgeSet4, int edgeSet5, int edgeSet6) {
		int orbits = 1;
		if(blankCorners == 0) {
			orbits *= 3; //divide by three automatically due to two extra orbits in the corners
		}
		if(blankCorners < 2 && cornerSet1 == 0) {
			orbits *= 2; //divide by two automatically due to an extra orbit in the corners
		}
		if(blankEdges == 0) {
			orbits *= 2; //divide by two automatically due to an extra orbit in the edges
		}
		BigInteger returnable = BigInteger.valueOf((long)Math.pow(3, 8)
				).multiply(BigInteger.valueOf((long)Math.pow(2, 12))
				).multiply(RubiksCalc.factorial(BigInteger.valueOf(12))
				).multiply(RubiksCalc.factorial(BigInteger.valueOf(8)));
		
		returnable = returnable.divide(BigInteger.valueOf((long) orbits)
				).divide(BigInteger.valueOf((long) Math.pow(3, blankCorners))
				).divide(BigInteger.valueOf((long) Math.pow(2, blankEdges))
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

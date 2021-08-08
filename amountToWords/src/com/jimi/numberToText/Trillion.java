package com.jimi.numberToText;

public final class Trillion {
	public static String TranslateToWords() {
		return "";
	}
/**
 * Converts numbers to an english readable words.<pre>
 * Examples<blockquote>
     * (1):
     * long tval=998L;
       Trillion.TranslateToWords(tval,"pwr"); returns "nine hundred and ninety-eight kilo-Watts hour, (998.00 kWh)"
	   <pre>
	   (2): Trillion.TranslateToWords(tval,"$"); returns "nine hundred and ninety-eight US Dollars, (US$ 998.00)"
     * </blockquote>
     * </pre>
 * @param value :<pre> Long Type</pre> 
 * @param mode : <pre> "pwr" ||"-pwr"||"negpwr"||"neg_pwr"||"neg pwr"|| "ghc"||"usd"||"$"||"us$"</pre> 
 * @return <pre> String</pre> 
 * @exception StringIndexOutOfBoundsException
 */
	public static String TranslateToWords(Long value, String mode) {
		String[] M = new String[9], L = new String[10], K = new String[8], Place = new String[5];
		String PN, Results = "";
		// ONES IN WORDS
		M[0] = "one";
		M[1] = "two";
		M[2] = "three";
		M[3] = "four";
		M[4] = "five";
		M[5] = "six";
		M[6] = "seven";
		M[7] = "eight";
		M[8] = "nine";

		// TENS IN WORDS
		L[0] = "ten";
		L[1] = "eleven";
		L[2] = "twelve";
		L[3] = "thirteen";
		L[4] = "fourteen";
		L[5] = "fifteen";
		L[6] = "sixteen";
		L[7] = "seventeen";
		L[8] = "eighteen";
		L[9] = "nineteen";

		K[0] = "twenty";
		K[1] = "thirty";
		K[2] = "forty";
		K[3] = "fifty";
		K[4] = "sixty";
		K[5] = "seventy";
		K[6] = "eighty";
		K[7] = "ninety";
		PN = "and ";

		// placement
		Place[0] = " hundred ";
		Place[1] = " thousand ";
		Place[2] = " million ";
		Place[3] = " billion ";
		Place[4] = " trillion ";
   
		 if (value.toString().length() > 15) {
			throw new StringIndexOutOfBoundsException(
					"OutOfRangeException\nMessage: Please consider setting a value not greater than 15 digits. "
							+ value.toString().length() +(value.toString().length()>1?" digits Keyed":" digit Keyed"));

		}
		if (value.toString().length() < 0) {
			throw new StringIndexOutOfBoundsException(
					"OutOfRangeException\nMessage: Please consider setting a value atleast  not less than one(1) digit  "
							+ value.toString().length() + (value.toString().length()<-1?" digits Keyed":" digit Keyed"));

		}
		if (Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 14, 1)) != 1) {
			Results = (String) Jayclass.Choose(
					Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 15, 1)) + 1, "", M[0],
					M[1], M[2], M[3], M[4], M[5], M[6], M[7], M[8]);
		} else {
			Results = (String) Jayclass.Choose(
					Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 15, 1)) + 1, L[0], L[1],
					L[2], L[3], L[4], L[5], L[6], L[7], L[8], L[9]);
		}

		if (Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 14, 1)) > 1
				&& Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 15, 1)) > 0) {
			Results = (String) Jayclass.Choose(
					Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 14, 1)) + 1, "", "", K[0],
					K[1], K[2], K[3], K[4], K[5], K[6], K[7]) + "-" + Results;

		} else {
			Results = (String) Jayclass.Choose(
					Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 14, 1)) + 1, "", "", K[0],
					K[1], K[2], K[3], K[4], K[5], K[6], K[7]) + Results;
		}
		if (Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 13, 1)) == 0) {

		} else if (Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 14, 1)) == 0
				&& Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 15, 1)) == 0) {

			Results = Place[0];
		} else {
			Results = Place[0] + PN + Results;
		}
		Results = (String) Jayclass.Choose(
				Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 13, 1)) + 1, "", M[0], M[1],
				M[2], M[3], M[4], M[5], M[6], M[7], M[8]) + Results;

		if (Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 10, 1)
				+ Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 11, 1)
				+ Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 12, 1)) == 0) {

		} else if (Integer
				.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 13, 1)
						+ Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 14, 1)
						+ Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 15, 1)) == 0
				|| Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 13, 1)) != 0) {
			Results = Place[1] + Results;

		} else {
			Results = Place[1] + PN + Results;

		}
		if (Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 11, 1)) != 1) {
			Results = (String) Jayclass.Choose(
					Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 12, 1)) + 1, "", M[0],
					M[1], M[2], M[3], M[4], M[5], M[6], M[7], M[8]) + Results;
		} else {
			Results = (String) Jayclass.Choose(
					Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 12, 1)) + 1, L[0], L[1],
					L[2], L[3], L[4], L[5], L[6], L[7], L[8], L[9]) + Results;
		}
		if (Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 11, 1)) > 1
				&& Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 12, 1)) > 0) {
			Results = (String) Jayclass.Choose(
					Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 11, 1)) + 1, "", "", K[0],
					K[1], K[2], K[3], K[4], K[5], K[6], K[7]) + "-" + Results;
		} else {
			Results = (String) Jayclass.Choose(
					Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 11, 1)) + 1, "", "", K[0],
					K[1], K[2], K[3], K[4], K[5], K[6], K[7]) + Results;
		}
		if (Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 10, 1)) == 0) {

		} else if (Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 11, 1)) == 0
				&& Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 12, 1)) == 0) {
			Results = Place[0] + Results;
		} else {
			Results = Place[0] + PN + Results;
		}
		Results = (String) Jayclass.Choose(
				Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 10, 1)) + 1, "", M[0], M[1],
				M[2], M[3], M[4], M[5], M[6], M[7], M[8]) + Results;

		if (Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 7, 1)
				+ Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 8, 1)
				+ Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 9, 1)) == 0) {
		} else if (Integer
				.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 10, 1)
						+ Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 11, 1)
						+ Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 12, 1)
						+ Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 13, 1)) == 0
				&& Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 14, 1)
						+ Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 15, 1)) > 0) {
			Results = Place[2] + PN + Results;
		} else {
			Results = Place[2] + Results;
		}
		if (Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 8, 1)) != 1) {
			Results = (String) Jayclass.Choose(
					Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 9, 1)) + 1, "", M[0], M[1],
					M[2], M[3], M[4], M[5], M[6], M[7], M[8]) + Results;
		} else {
			Results = (String) Jayclass.Choose(
					Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 9, 1)) + 1, L[0], L[1],
					L[2], L[3], L[4], L[5], L[6], L[7], L[8], L[9]) + Results;

		}
		if (Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 8, 1)) > 1
				&& Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 9, 1)) > 0) {
			Results = (String) Jayclass.Choose(
					Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 8, 1)) + 1, "", "", K[0],
					K[1], K[2], K[3], K[4], K[5], K[6], K[7]) + "-" + Results;
		} else {
			Results = (String) Jayclass.Choose(
					Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 8, 1)) + 1, "", "", K[0],
					K[1], K[2], K[3], K[4], K[5], K[6], K[7]) + Results;
		}

		if (Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 7, 1)) == 0) {

		} else if (Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 8, 1)) == 0
				&& Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 9, 1)) == 0) {
			Results = Place[0] + Results;
		} else {
			Results = Place[0] + PN + Results;
		}
		Results = (String) Jayclass.Choose(
				Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 7, 1)) + 1, "", M[0], M[1],
				M[2], M[3], M[4], M[5], M[6], M[7], M[8]) + Results;
		if (Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 4, 1)
				+ Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 5, 1)
				+ Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 6, 1)) == 0) {

		} else if (Integer
				.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 7, 1)
						+ Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 8, 1)
						+ Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 9, 1)
						+ Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 10, 1)
						+ Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 11, 1)
						+ Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 12, 1)
						+ Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 13, 1)) == 0
				&& Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 14, 1)
						+ Jayclass.Right(Jayclass.Format(value, "000000000000000"), 1)) > 0) {
			Results = Place[3] + PN + Results;
		} else {
			Results = Place[3] + Results;
		}
		if (Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 5, 1)) != 1) {
			Results = (String) Jayclass.Choose(
					Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 6, 1)) + 1, "", M[0], M[1],
					M[2], M[3], M[4], M[5], M[6], M[7], M[8]) + Results;
		} else {
			Results = (String) Jayclass.Choose(
					Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 6, 1)) + 1, L[0], L[1],
					L[2], L[3], L[4], L[5], L[6], L[7], L[8], L[9]) + Results;
		}
		if (Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 5, 1)) > 1
				&& Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 6, 1)) > 0) {
			Results = (String) Jayclass.Choose(
					Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 5, 1)) + 1, "", "", K[0],
					K[1], K[2], K[3], K[4], K[5], K[6], K[7]) + "-" + Results;
		} else {
			Results = (String) Jayclass.Choose(
					Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 5, 1)) + 1, "", "", K[0],
					K[1], K[2], K[3], K[4], K[5], K[6], K[7]) + Results;
		}

		if (Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 4, 1)) == 0) {
		} else if (Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 5, 1)) == 0
				&& Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 6, 1)) == 0) {
			Results = Place[0] + Results;
		} else {
			Results = Place[0] + PN + Results;
		}
		Results = (String) Jayclass.Choose(
				Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 4, 1)) + 1, "", M[0], M[1],
				M[2], M[3], M[4], M[5], M[6], M[7], M[8]) + Results;
		if (Integer.parseInt(Jayclass.Left(Jayclass.Format(value, "000000000000000"), 1)
				+ Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 2, 1)
				+ Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 3, 1)) == 0) {
		} else if (Long
				.parseLong(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 4, 1)
						+ Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 5, 1)
						+ Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 6, 1)
						+ Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 7, 1)
						+ Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 8, 1)
						+ Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 9, 1)
						+ Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 10, 1)
						+ Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 11, 1)
						+ Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 12, 1)
						+ Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 13, 1)) == 0
				&& Long.parseLong(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 14, 1)
						+ Jayclass.Right(Jayclass.Format(value, "000000000000000"), 1)) > 0) {
			Results = Place[4] + PN + Results;

		} else {
			Results = Place[4] + Results;
		}
		if (Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 2, 1)) != 1) {
			Results = (String) Jayclass.Choose(
					Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 3, 1)) + 1, "", M[0], M[1],
					M[2], M[3], M[4], M[5], M[6], M[7], M[8]) + Results;
		} else {
			Results = (String) Jayclass.Choose(
					Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 3, 1)) + 1, L[0], L[1],
					L[2], L[3], L[4], L[5], L[6], L[7], L[8], L[9]) + Results;
		}

		if (Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 2, 1)) > 1
				&& Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 3, 1)) > 0) {
			Results = (String) Jayclass.Choose(
					Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 2, 1)) + 1, "", "", K[0],
					K[1], K[2], K[3], K[4], K[5], K[6], K[7]) + "-" + Results;
		} else {
			Results = (String) Jayclass.Choose(
					Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 2, 1)) + 1, "", "", K[0],
					K[1], K[2], K[3], K[4], K[5], K[6], K[7]) + Results;
		}
		if (Integer.parseInt(Jayclass.Left(Jayclass.Format(value, "000000000000000"), 1)) == 0) {
		} else if (Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 2, 1)) == 0
				&& Integer.parseInt(Jayclass.Mid(Jayclass.Format(value, "000000000000000"), 3, 1)) == 0) {
			Results = Place[0] + Results;
		} else {
			Results = Place[0] + PN + Results;
		}

		Results = (String) Jayclass.Choose(
				Integer.parseInt(Jayclass.Left(Jayclass.Format(value, "000000000000000"), 1)) + 1, "", M[0], M[1], M[2],
				M[3], M[4], M[5], M[6], M[7], M[8]) + Results;
		
				Results= Jayclass.checkCurrency(value,Results,mode);
			// 	if (mode.toLowerCase() == "pwr")
            // {
            //     Results = Results + " kilo-Watts hour, ("+Jayclass.Format(value, "#,###.00")+"kWh)";
            // }else if (mode.toLowerCase() == "amnt")
            // {
            //     Results = Results +" Ghana Cedis, (Gh¢" + Jayclass.Format(value, "#,###.00") + ")";
            // }

	
		return Results;
	}
}

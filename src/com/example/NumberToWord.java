package com.example;

public class NumberToWord {

  private static final String[] ones = {
    " one",
    " two",
    " three",
    " four",
    " five",
    " six",
    " seven",
    " eight",
    " nine",
    " ten",
    " eleven",
    " twelve",
    " thirteen",
    " fourteen",
    " fifteen",
    " sixteen",
    " seventeen",
    " eighteen",
    " nineteen"
  };
  private static final String[] tens = {
    " twenty",
    " thirty",
    " forty",
    " fifty",
    " sixty",
    " seventy",
    " eighty",
    " ninety"
  };
  // the program does not handle numbers larger than quintillions
  // this is ok for now
  //
  private static final String[] groups = {
    "",
    " thousand",
    " million",
    " billion",
    " trillion",
    " quadrillion",
    " quintillion"
  };
  private String string = new String();

  public String getString() {
    return string;
  }

  public NumberToWord( long n ) {
    // Go through the number one group at a time.
    for( int i = groups.length - 1; i >= 0; i-- ) {
      // Is the number as big as this group?
      long cutoff = ( long )Math.pow( 10, i * 3 );
      if( n >= cutoff ) {
        int thisPart = ( int )( n / cutoff );
        // Use the ones[] array for both the
        // hundreds and the ones digit. Note
        // that tens[] starts at "twenty".
        if( thisPart >= 100 ) {
          string += ones[ thisPart / 100 ] + " hundred";
          thisPart = thisPart % 100;
        }
        if( thisPart >= 20 ) {
          string += tens[ ( thisPart / 10 ) - 1 ];
          thisPart = thisPart % 10;
        }
        if( thisPart >= 1 ) {
          string += ones[ thisPart ];
        }
        string += groups[ i ];
        n = n % cutoff;
      }
    }
    string = string.substring( 1 );
  }
}

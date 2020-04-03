package com.company;

/**
 * Token class stores the values of the tokens
 *
 */
public class Token{
    Integer number;

    public Token(Integer number){
        this.number = number;
    }

    public Token(){
        number = null;
    }

    public Integer getNumber() {
        return number;
    }

    @Override
    public String toString() {
        if (number != null)
            return "token =>" + number;

        return "token => blank";
    }
}

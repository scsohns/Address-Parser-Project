/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.addressparserproject;

/**
 *
 * @author Stephen Sohns
 */
import org.parboiled.Parboiled;
import org.parboiled.parserunners.RecoveringParseRunner;
import org.parboiled.common.StringUtils;
import static org.parboiled.support.ParseTreeUtils.printNodeTree;
import org.parboiled.support.ParsingResult;

import java.util.Scanner;

public class Main {
    
    public static void main(String[]args){
        AddressParser parser = Parboiled.createParser(AddressParser.class);
        while (true) {
            System.out.print("Enter an address(“street number street name, city, zip code, state (two letters), country name), single RETURN to exit)!\n");
            String input = new Scanner(System.in).nextLine();
            
            if (StringUtils.isEmpty(input)) break;

            ParsingResult<?> result = new RecoveringParseRunner(parser.Address()).run(input);

            
            System.out.println(printNodeTree(result) + '\n');
            
            if (!result.matched) {
                System.out.println(StringUtils.join(result.parseErrors, "---\n"));
            }
        }
    }
}

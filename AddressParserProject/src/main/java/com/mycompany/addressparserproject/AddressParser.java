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
import org.parboiled.BaseParser;
import org.parboiled.Rule;
import org.parboiled.annotations.BuildParseTree;
@BuildParseTree
public class AddressParser extends BaseParser<Object>{
    
    public Rule Address(){
        return Sequence(
                Number(),' ',//3609
                LongName(), ',',' ',//Mynders Ave,
                LongName(),',',' ',//Memphis,
                Number(),',',' ',//38111,
                State(),',',' ',//TN,
                LongName(),//United States of America
                EOI);
    }
    Rule LongName(){
        return Sequence(Name(), ZeroOrMore(' ',Name()));
    }
    
    Rule Name(){
        return Sequence(Optional(CharRange('A', 'Z')), OneOrMore(CharRange('a','z')));
    }
    
    Rule Number(){
        return OneOrMore(CharRange('0','9'));
    }
    
    Rule State(){
        return Sequence(CharRange('A','Z'),CharRange('A','Z'));
    }
}

package com.sid;
import java.util.ArrayList;

public class ChainOfBharat {
	
	public static void main(String[] args) {
		ArrayList<Block> blockChain  = new ArrayList<Block>();
		int difficulty =5;
		blockChain.add(new Block("Hi im the first block", "0"));
		System.out.println("Trying to Mine block 1... ");
		blockChain.get(0).mineBlock(difficulty);
		
		blockChain.add(new Block("Yo im the second block",blockChain.get(blockChain.size()-1).getCurrHash()));
		System.out.println("Trying to Mine block 2... ");
		blockChain.get(1).mineBlock(difficulty);
		
		blockChain.add(new Block("Hey im the third block",blockChain.get(blockChain.size()-1).getCurrHash()));
		System.out.println("Trying to Mine block 3... ");
		blockChain.get(2).mineBlock(difficulty);	
		
		System.out.println("\nblockChain is Valid: " + isChainValid(blockChain,difficulty));
		
		System.out.println("\nThe block chain: ");
		System.out.println(blockChain);
		
		
		System.out.println(blockChain);
	
	}
	public static boolean isChainValid(ArrayList<Block> blockChain,int difficulty) {
		String hashTarget = new String(new char[difficulty]).replace('\0', '0');
		boolean isValid = true;
		for(int i = 1;i<blockChain.size();i++) {
			Block currBlock = blockChain.get(i);
			Block prevBlock = blockChain.get(i-1);
			if(currBlock.getPrevHash().equals(prevBlock.getCurrHash())) {
				continue;
			}else {
				isValid = false;
			}
			if(!currBlock.getCurrHash().equals(currBlock.calculateHash())){
				isValid = false;
			}
			if(!currBlock.getCurrHash().substring(0, difficulty).equals(hashTarget)) {
				isValid = false;
			}
		}
		return isValid;
	}
}

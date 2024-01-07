package com.sid;
import java.util.Date;
public class Block {
		String currHash;
		String prevHash;
		String data;
		Long timeStamp;
		int nonce;
		
		public Block(String data,String prevHash) {
			this.data = data;
			this.prevHash = prevHash;
			this.timeStamp = new Date().getTime();
			this.currHash = calculateHash();
		}
		
		public String getCurrHash() {
			return currHash;
		}
		public void setCurrHash(String currHash) {
			this.currHash = currHash;
		}
		public String getPrevHash() {
			return prevHash;
		}
		public void setPrevHash(String prevHash) {
			this.prevHash = prevHash;
		}
		public String getData() {
			return data;
		}
		public void setData(String data) {
			this.data = data;
		}
		public Long getTimeStamp() {
			return timeStamp;
		}
		public void setTimeStamp(Long timeStamp) {
			this.timeStamp = timeStamp;
		}
		
		public String calculateHash() {
			String calculateedHash = MyStringUtil.applySHA256(
					getPrevHash()
					+getTimeStamp().toString()
					+Integer.toString(nonce)
					+getData());
			return calculateedHash;
		}

		@Override
		public String toString() {
		    return "{\n"
		            + "  \"currHash\": \"" + currHash + "\",\n"
		            + "  \"prevHash\": \"" + prevHash + "\",\n"
		            + "  \"data\": \"" + data + "\",\n"
		            + "  \"timeStamp\": " + timeStamp + "\n"
		            + "}";
		}
		public void mineBlock(int difficulty) {
			String target = new String(new char[difficulty]).replace('\0', '0');
			while(!currHash.substring(0,difficulty).equals(target)) {
				nonce++;
				setCurrHash(calculateHash());
			}
			System.out.println("Block mined!!");
		}

		
}

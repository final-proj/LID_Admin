package com.kh.lida.memberManagement.model.vo;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class Payment implements Serializable{

   /**
    * 
    */
   private static final long serialVersionUID = 1004L;
   
   
   private int pNo;
   private Date pDate;
   private Date poDate;
   private int pTicket;
   private int pMno;
   
   
   public Payment() {
      
   }
   
   
   public Payment(int pNo, Date pDate, Date poDate, int pTicket, int pMno) {
      super();
      this.pNo = pNo;
      this.pDate = pDate;
      this.poDate = poDate;
      this.pTicket = pTicket;
      this.pMno = pMno;
   }


   public int getpNo() {
      return pNo;
   }


   public void setpNo(int pNo) {
      this.pNo = pNo;
   }


   public Date getpDate() {
      return pDate;
   }


   public void setpDate(Date pDate) {
      this.pDate = pDate;
   }


   public Date getPoDate() {
      return poDate;
   }


   public void setPoDate(Date poDate) {
      this.poDate = poDate;
   }


   public int getpTicket() {
      return pTicket;
   }


   public void setpTicket(int pTicket) {
      this.pTicket = pTicket;
   }


   public int getpMno() {
      return pMno;
   }


   public void setpMno(int pMno) {
      this.pMno = pMno;
   }


   @Override
   public String toString() {
      return "Payment [pNo=" + pNo + ", pDate=" + pDate + ", poDate=" + poDate + ", pTicket=" + pTicket + ", pMno="
            + pMno + "]";
   }


   
   
}
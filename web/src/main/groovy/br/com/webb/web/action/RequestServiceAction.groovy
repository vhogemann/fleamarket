package br.com.webb.web.action;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.webb.model.Request;
import br.com.webb.service.RequestService

class RequestServiceAction{
	@Autowired
	RequestService service

	String entity
	String objectId
	String reason
	String staticURLBase

	def publish(){
		service.publish(entity,reason)
		return "success"
	}

	def approve(){
		service.approve(entity,reason)
		return "success"
	}

	def cancel(){
		service.cancel(entity,reason)
		return "success"
	}

	def endQuoting(){
		service.endQuoting(entity,reason)
		return "success"
	}

	def approveQuote(){
		service.approveQuote(entity,objectId)
		return "success"
	}

	def approveBestQuote(){
		service.approveBestQuote(entity)
		return "success"
	}

	def execute(){
		return "success"
	}

	def setService(RequestService service){
		this.service = service
	}

	def setStaticURLBase(String s){
		staticURLBase = s
	}
}
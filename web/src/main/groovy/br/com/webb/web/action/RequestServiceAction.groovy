package br.com.webb.web.action;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.webb.service.RequestService

class RequestServiceAction{
	@Autowired
	RequestService service

	String requestId
	String objectId
	String reason
	String staticURLBase

	def publish(){
		service.publish(requestId,reason)
		return "success"
	}

	def approve(){
		service.approve(requestId,reason)
		return "success"
	}

	def cancel(){
		service.cancel(requestId,reason)
		return "success"
	}

	def endQuoting(){
		service.endQuoting(requestId,reason)
		return "success"
	}

	def approveQuote(){
		service.approveQuote(requestId,objectId)
		return "success"
	}

	def approveBestQuote(){
		service.approveBestQuote(requestId)
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
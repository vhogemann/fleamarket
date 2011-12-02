package br.com.ideais.web.action

import org.junit.Test
import static junit.framework.Assert.*;


import br.com.ideais.model.AbstractEntity

abstract class AbstractEntityActionTest <E extends AbstractEntity> {

	def SUCCESS = "success"
	
	@Test
	def showTest(){
		getAction().setEntityId(existingEntity().getId())
		def actual = getAction().show()
		assertEquals(SUCCESS, actual)
	}
	
	@Test
	def listTest(){
		def actual = getAction().list()
		assertEquals(SUCCESS, actual)
	}
	
	@Test
	def createTest(){
		def actual = getAction().create()
		assertEquals(SUCCESS, actual)
	}
	
	@Test
	def saveTest(){
		getAction().setEntity(validEntity())
		def actual = getAction().save()
		assertEquals(SUCCESS, actual)
	}
	
	@Test
	def updateTest(){
	
	}

	abstract E validEntity();
	
	abstract E invalidEntity();
	
	abstract E existingEntity();
		
	abstract AbstractEntityAction<E> getAction();
}

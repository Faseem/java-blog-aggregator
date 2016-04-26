package com.fsm.app.service;

import static org.junit.Assert.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.fsm.app.entity.Item;
import com.fsm.app.exception.RssException;

public class RssServiceTest {
	
	private RssService rssService;

	@Before
	public void setUp() throws Exception {
		rssService=new RssService();
	}

	@Test
	public void testGetItemsFile() throws RssException {
		List<Item> items=rssService.getItems(new File("test-rss/javavids.xml"));
		//List<Item> items=rssService.getItems(new File("http://feeds.feedburner.com/javavids?format=xml"));
		assertEquals(10,items.size());
		Item firstItem=items.get(0);
		assertEquals("How to generate web.xml in Eclipse", firstItem.getTitle());
		//assertEquals("23 03 2014 09:01:34", new SimpleDateFormat("dd MM yyyy HH:mm:ss").format(firstItem.getPublishedDate()));
		
	}

/*	@Test
	public void testGetItemsString() {
		fail("Not yet implemented");
	}*/

}

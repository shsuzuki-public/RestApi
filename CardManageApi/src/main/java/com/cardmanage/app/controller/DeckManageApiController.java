package com.cardmanage.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cardmanage.domain.service.ClanMService;
import com.cardmanage.domain.service.DeckMService;
import com.cardmanage.infrastructure.entity.ClanEntity;
import com.cardmanage.infrastructure.entity.DeckDetailT;
import com.cardmanage.infrastructure.entity.DeckM;

@RestController
@RequestMapping(value="/deck")
public class DeckManageApiController {
	@Autowired
	DeckMService deckMService;

	@RequestMapping(method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<DeckM> getDeckList(){
		return deckMService.getAllDeckList();		
	}

	@RequestMapping(value="/{clanId}", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<DeckM> getDeckList(@PathVariable("clanId") Integer clanId){
		return deckMService.getTargetClanDecks(clanId);
	}

	/*@RequestMapping(value="/detail/{deckId}", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<DeckDetailT> getDeckDetailList(@PathVariable("deckId") Integer deckId){
		return deckMService.getDeckDetail(deckId);
	}
*/
	@RequestMapping(method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public DeckM createDeck(@RequestBody DeckM deck){
		return deckMService.createDeck(deck);
	}
}

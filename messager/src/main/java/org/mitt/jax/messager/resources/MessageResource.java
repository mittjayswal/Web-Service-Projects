package org.mitt.jax.messager.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.mitt.jax.messager.resources.beans.MessageFilterBean;
import org.mitt.jax.messager.model.Message;
import org.mitt.jax.messager.service.MessageService;

import com.sun.jndi.toolkit.url.Uri;

import jdk.nashorn.internal.objects.annotations.Getter;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)// we can write here it into anove class so that we dont need it write into every method
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public class MessageResource {

	MessageService messageService = new MessageService();
	@GET
	public List<Message> getMessages(//@QueryParam ("year") int year,
									 //@QueryParam ("start") int start,
									 //@QueryParam ("size") int size    We can use the following ways if more param
									@BeanParam MessageFilterBean filterBean) {
		if (filterBean.getYear() >0) {
			return messageService.getAllMessagesForYear(filterBean.getYear());
		}
		if (filterBean.getStart() >0 && filterBean.getSize() >0) {
			return messageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
			
		}
		return messageService.getAllMessages();
	}
	
	@POST
	public Response addMessage(Message message, @Context UriInfo uriInfo)  {
		
		Message newMessage = messageService.addMessage(message);
		String newId = String.valueOf(newMessage.getId());
		URI uri =uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri)                      //new URI("/messager/webapi/messages/"+newMessage.getId()))					//status(Status.CREATED)
					   .entity(newMessage)
					   .build();
	}
	
	@PUT
	@Path("/{meessageId}")
	//@Consumes(MediaType.APPLICATION_JSON)
	//@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") long messageId, Message message) {
		message.setId(messageId);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	//@Produces(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("messageId") long id) {
		messageService.removeMessage(id);
	}
	
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long messageId, @Context UriInfo uriInfo) { //Jersey automatically convert to long
		Message message = messageService.getMessage(messageId);
		message.addLink(getUriForSelf(uriInfo, message), "self");
		return message;
		 
		 
	}

	private String getUriForSelf(UriInfo uriInfo, Message message) {
		String uri = uriInfo.getBaseUriBuilder()
			.path(MessageResource.class)
			.path(Long.toString(message.getId()))
			.build()
			.toString();
		return uri;
	}
	
	//@GET to get all request dont use any http methods
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
	}
}

package com.yard42;

import java.time.LocalTime;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.sse.Sse;
import javax.ws.rs.sse.SseBroadcaster;
import javax.ws.rs.sse.SseEventSink;

@Singleton
@Path("beats")
public class BroadcastResource
{
   private SseBroadcaster broadcaster;
   private Sse sse;

   @GET
   @Produces(MediaType.SERVER_SENT_EVENTS)
   public void register(@Context Sse sse, @Context SseEventSink eventSink)
   {
      this.sse = sse;

      if (broadcaster == null)
      {
         this.broadcaster = sse.newBroadcaster();
      }

      this.broadcaster.register(eventSink);
   }

   @Schedule(second = "*/2", minute = "*", hour = "*")
   public void beat()
   {
      System.out.println(".");
      this.broadcaster.broadcast(this.sse.newEvent("time: " + LocalTime.now().toString()));
   }
}

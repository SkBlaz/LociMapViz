




library(ggplot2)
library(plyr)
library(gridExtra)




args <- commandArgs(trailingOnly = TRUE)

    
    file <- paste(args[1])
    alignment <- read.csv(file)
    alignment = ddply(alignment, .(loci), transform, percent = count/sum(count))
    p1 <- ggplot(alignment, aes(x=loci,y=count,group=type,fill=type))+ 
      geom_bar(stat="identity",position="stack")+ scale_x_continuous(breaks=unique(alignment$loci))+
      geom_text(position = "stack", aes(x = loci, y = count, ymax = 25, label =paste(round(percent,1))),size=2,hjust = 1.5)+ggtitle("Percentage plot")
    
    p1
    a<-ddply(alignment, .(loci), transform, std = sd(count))
    a[is.na(a)]<-0
    #a<-aggregate(count~loci,data=alignment,FUN=sd)
    p2 <- ggplot(a, aes(x=loci,y=std,colour=std))+ 
      geom_pointrange(ymax=mean(a$std),ymin=0,size=1.2)+ 
      scale_x_continuous(breaks=unique(alignment$loci))+ggtitle("Standard deviation plot")
    p2
    
    a<-ddply(alignment, .(loci), transform, mean = mean(count))
    a[is.na(a)]<-0
    #a<-aggregate(count~loci,data=alignment,FUN=sd)
    p3 <- ggplot(a, aes(x=loci,y=mean, group=loci,fill=mean))+ 
      geom_bin2d()+ scale_x_continuous(breaks=unique(alignment$loci))+ggtitle("Mean plot")
    p3
    
    
    png(args[2],width=as.integer(args[3]), 
        height=as.integer(args[4]))
    grid.arrange(p1, p2,p3, nrow=3)
    dev.off()
    

      
  



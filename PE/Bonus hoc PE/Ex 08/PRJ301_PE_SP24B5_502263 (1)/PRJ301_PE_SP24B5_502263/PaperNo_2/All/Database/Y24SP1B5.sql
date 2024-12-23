USE [master]
GO
Create database Y24SP1B5
GO
USE Y24SP1B5
GO

CREATE TABLE [dbo].[DepartPlaces](
	[DepartPlaceID] int NOT NULL primary key,
	[DepartPlaceName] [nvarchar](30) NOT NULL,
)
GO
insert into [DepartPlaces] values(1,'Ha Noi')
insert into [DepartPlaces] values(2,'Ho Chi Minh')
insert into [DepartPlaces] values(3,'Da Nang')
GO

CREATE TABLE [dbo].[Tickets](
	[TicketID] int NOT NULL primary key,
	[TicketName] [nvarchar](30) NOT NULL,
)
GO
insert into [Tickets] values(1,'Standard')
insert into [Tickets] values(2,'VIP')
insert into [Tickets] values(3,'SuperVIP')
GO

CREATE TABLE [dbo].[Boats](
	[BoatID] [nvarchar](10) NOT NULL primary key,
	[BoatName] [nvarchar](30) NOT NULL,
	[Seat] int NOT NULL,
	[Booked] int NOT NULL,
	[DepartPlaceID] int references [DepartPlaces]([DepartPlaceID]),
	[TicketID] int references [Tickets]([TicketID])
)
GO

insert into Boats values('B001','Sug',12,3,1,1)
insert into Boats values('B002','Mil',10,6,2,2)
insert into Boats values('B003','App',5,5,3,3)
insert into Boats values('B004','Roo',7,6,1,2)
insert into Boats values('B005','Bee',11,4,2,3)
insert into Boats values('B006','Boo',9,7,3,1)
GO

CREATE TABLE [dbo].[Trains](
	[TrainID] [nvarchar](10) NOT NULL primary key,
	[TrainName] [nvarchar](30) NOT NULL,
	[Seat] int NOT NULL,
	[Booked] int NOT NULL,
	[DepartPlaceID] int references [DepartPlaces]([DepartPlaceID]),
	[TicketID] int references [Tickets]([TicketID])
)
GO

insert into Trains values('T01','SE4',200,30,1,2)
insert into Trains values('T02','Vietage',100,60,2,3)
insert into Trains values('T03','SE1',500,350,3,1)
insert into Trains values('T04','SE2',700,700,3,2)
insert into Trains values('T05','SE19',110,100,2,1)
insert into Trains values('T06','SE9',90,79,1,3)
GO
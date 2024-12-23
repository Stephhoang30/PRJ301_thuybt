USE [PRJ30X_PE_BLOCK5_SP2023]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 4/20/2023 9:52:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[username] [varchar](150) NOT NULL,
	[password] [varchar](150) NOT NULL,
	[displayname] [varchar](150) NOT NULL,
 CONSTRAINT [PK_AccountTBL] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Product]    Script Date: 4/20/2023 9:52:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[id] [int] NOT NULL,
	[name] [varchar](150) NOT NULL,
	[price] [float] NOT NULL,
 CONSTRAINT [PK_Product] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PurchaseOrder]    Script Date: 4/20/2023 9:52:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PurchaseOrder](
	[id] [int] NOT NULL,
	[created_by] [varchar](150) NOT NULL,
	[date] [date] NOT NULL,
 CONSTRAINT [PK_PurchaseOrder] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PurchaseOrderProduct]    Script Date: 4/20/2023 9:52:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PurchaseOrderProduct](
	[poid] [int] NOT NULL,
	[pid] [int] NOT NULL,
	[quantity] [float] NOT NULL,
	[purchaseprice] [float] NOT NULL,
 CONSTRAINT [PK_PurchaseOrderProduct] PRIMARY KEY CLUSTERED 
(
	[poid] ASC,
	[pid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SaleOrder]    Script Date: 4/20/2023 9:52:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SaleOrder](
	[id] [int] NOT NULL,
	[created_by] [varchar](150) NOT NULL,
	[date] [date] NOT NULL,
 CONSTRAINT [PK_SaleOrder] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SaleOrderProduct]    Script Date: 4/20/2023 9:52:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SaleOrderProduct](
	[sid] [int] NOT NULL,
	[pid] [int] NOT NULL,
	[quantity] [float] NOT NULL,
	[saleprice] [float] NOT NULL,
 CONSTRAINT [PK_SaleOrderProduct] PRIMARY KEY CLUSTERED 
(
	[sid] ASC,
	[pid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Account] ([username], [password], [displayname]) VALUES (N'mra', N'mra', N'Mr A')
INSERT [dbo].[Account] ([username], [password], [displayname]) VALUES (N'mrb', N'mrb', N'Mr B')
INSERT [dbo].[Account] ([username], [password], [displayname]) VALUES (N'mrc', N'mrc', N'mr C')
GO
INSERT [dbo].[Product] ([id], [name], [price]) VALUES (1, N'Cocacola', 10)
INSERT [dbo].[Product] ([id], [name], [price]) VALUES (2, N'Pepsi', 8)
INSERT [dbo].[Product] ([id], [name], [price]) VALUES (3, N'Fanta', 9.5)
INSERT [dbo].[Product] ([id], [name], [price]) VALUES (4, N'Sting', 5.5)
INSERT [dbo].[Product] ([id], [name], [price]) VALUES (5, N'Monster', 50)
GO
INSERT [dbo].[PurchaseOrder] ([id], [created_by], [date]) VALUES (9981, N'mra', CAST(N'2023-04-18' AS Date))
INSERT [dbo].[PurchaseOrder] ([id], [created_by], [date]) VALUES (9982, N'mra', CAST(N'2023-04-11' AS Date))
GO
INSERT [dbo].[PurchaseOrderProduct] ([poid], [pid], [quantity], [purchaseprice]) VALUES (9981, 1, 2, 10)
INSERT [dbo].[PurchaseOrderProduct] ([poid], [pid], [quantity], [purchaseprice]) VALUES (9981, 2, 1, 8)
INSERT [dbo].[PurchaseOrderProduct] ([poid], [pid], [quantity], [purchaseprice]) VALUES (9981, 3, 1, 9.5)
INSERT [dbo].[PurchaseOrderProduct] ([poid], [pid], [quantity], [purchaseprice]) VALUES (9982, 1, 3, 10.5)
GO
INSERT [dbo].[SaleOrder] ([id], [created_by], [date]) VALUES (9981, N'mra', CAST(N'2023-04-18' AS Date))
INSERT [dbo].[SaleOrder] ([id], [created_by], [date]) VALUES (9982, N'mra', CAST(N'2023-04-11' AS Date))
GO
INSERT [dbo].[SaleOrderProduct] ([sid], [pid], [quantity], [saleprice]) VALUES (9981, 1, 2, 10)
INSERT [dbo].[SaleOrderProduct] ([sid], [pid], [quantity], [saleprice]) VALUES (9981, 2, 1, 8)
INSERT [dbo].[SaleOrderProduct] ([sid], [pid], [quantity], [saleprice]) VALUES (9981, 3, 1, 9.5)
INSERT [dbo].[SaleOrderProduct] ([sid], [pid], [quantity], [saleprice]) VALUES (9982, 1, 3, 10.5)
GO
ALTER TABLE [dbo].[PurchaseOrder]  WITH CHECK ADD  CONSTRAINT [FK_PurchaseOrder_AccountTBL] FOREIGN KEY([created_by])
REFERENCES [dbo].[Account] ([username])
GO
ALTER TABLE [dbo].[PurchaseOrder] CHECK CONSTRAINT [FK_PurchaseOrder_AccountTBL]
GO
ALTER TABLE [dbo].[PurchaseOrderProduct]  WITH CHECK ADD  CONSTRAINT [FK_PurchaseOrderProduct_Product] FOREIGN KEY([pid])
REFERENCES [dbo].[Product] ([id])
GO
ALTER TABLE [dbo].[PurchaseOrderProduct] CHECK CONSTRAINT [FK_PurchaseOrderProduct_Product]
GO
ALTER TABLE [dbo].[PurchaseOrderProduct]  WITH CHECK ADD  CONSTRAINT [FK_PurchaseOrderProduct_PurchaseOrder] FOREIGN KEY([poid])
REFERENCES [dbo].[PurchaseOrder] ([id])
GO
ALTER TABLE [dbo].[PurchaseOrderProduct] CHECK CONSTRAINT [FK_PurchaseOrderProduct_PurchaseOrder]
GO
ALTER TABLE [dbo].[SaleOrder]  WITH CHECK ADD  CONSTRAINT [FK_SaleOrder_AccountTBL] FOREIGN KEY([created_by])
REFERENCES [dbo].[Account] ([username])
GO
ALTER TABLE [dbo].[SaleOrder] CHECK CONSTRAINT [FK_SaleOrder_AccountTBL]
GO
ALTER TABLE [dbo].[SaleOrderProduct]  WITH CHECK ADD  CONSTRAINT [FK_SaleOrderProduct_Product] FOREIGN KEY([pid])
REFERENCES [dbo].[Product] ([id])
GO
ALTER TABLE [dbo].[SaleOrderProduct] CHECK CONSTRAINT [FK_SaleOrderProduct_Product]
GO
ALTER TABLE [dbo].[SaleOrderProduct]  WITH CHECK ADD  CONSTRAINT [FK_SaleOrderProduct_SaleOrder] FOREIGN KEY([sid])
REFERENCES [dbo].[SaleOrder] ([id])
GO
ALTER TABLE [dbo].[SaleOrderProduct] CHECK CONSTRAINT [FK_SaleOrderProduct_SaleOrder]
GO

describe("GET /api/precio/busquedaPrecios", () => {
    it("Test 1: petición a las 10:00 del día 14 del producto 35455", () => {
        cy.request({
            method: "GET",
            url: "/api/precio/busquedaPrecios",
            qs: {
                fechaAplicacion: "2020-06-14T10:00:00Z",
                cadenaId: 1,
                productoId: 35455,
            },
            headers: {
                Accept: "application/json",
            },
        }).then((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).to.be.an("array");
        });
    });
    it("Test 2: petición a las 16:00 del día 14 del producto 35455", () => {
        cy.request({
            method: "GET",
            url: "/api/precio/busquedaPrecios",
            qs: {
                fechaAplicacion: "2020-06-14T16:00:00Z",
                cadenaId: 1,
                productoId: 35455,
            },
            headers: {
                Accept: "application/json",
            },
        }).then((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).to.be.an("array");
        });
    });
    it("Test 3: petición a las 21:00 del día 14 del producto 35455", () => {
        cy.request({
            method: "GET",
            url: "/api/precio/busquedaPrecios",
            qs: {
                fechaAplicacion: "2020-06-14T21:00:00Z",
                cadenaId: 1,
                productoId: 35455,
            },
            headers: {
                Accept: "application/json",
            },
        }).then((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).to.be.an("array");
        });
    });
    it("Test 4: petición a las 10:00 del día 15 del producto 35455", () => {
        cy.request({
            method: "GET",
            url: "/api/precio/busquedaPrecios",
            qs: {
                fechaAplicacion: "2020-06-15T10:00:00Z",
                cadenaId: 1,
                productoId: 35455,
            },
            headers: {
                Accept: "application/json",
            },
        }).then((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).to.be.an("array");
        });
    });
    it("Test 5: petición a las 21:00 del día 16 del producto 35455", () => {
        cy.request({
            method: "GET",
            url: "/api/precio/busquedaPrecios",
            qs: {
                fechaAplicacion: "2020-06-16T21:00:00Z",
                cadenaId: 1,
                productoId: 35455,
            },
            headers: {
                Accept: "application/json",
            },
        }).then((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).to.be.an("array");
        });
    });
});
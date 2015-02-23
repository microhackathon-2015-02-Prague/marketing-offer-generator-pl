io.coderate.accurest.dsl.GroovyDsl.make {
    request {
        method 'GET'
        url $(client(regex('/api/marketing/.*')), server('/api/marketing/Chuck_Norris'))
        headers {
            header 'Content-Type': 'application/json'
        }
    }
    response {
        headers {
            header 'Content-Type': 'application/json'
        }
        body '''\
    [{
        "marketingOffer" : "The best offer in the world"
    }]
'''
    }
}